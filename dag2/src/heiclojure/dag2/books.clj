(ns heiclojure.dag2.books
  (:require
   [datomic.api :as d]))

(def schema
  [{:db/ident :goodreads/id
    :db/valueType :db.type/long
    :db/cardinality :db.cardinality/one
    :db/unique :db.unique/identity}

   {:db/ident :goodreads/url
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one}

   {:db/ident :goodreads/type
    :db/valueType :db.type/keyword
    :db/cardinality :db.cardinality/one}

   {:db/ident :goodreads/title
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one}

   {:db/ident :goodreads/author
    :db/valueType :db.type/ref
    ;; We choose to allow multiple authors of one book
    :db/cardinality :db.cardinality/many}

   {:db/ident :goodreads/series
    :db/valueType :db.type/ref
    ;; We choose to allow a book to be part of multiple series
    :db/cardinality :db.cardinality/many}])

;; Gjør vi skriver ut {:goodreads/id 38550} i stedet for #:goodreads{:id 38550}.
;; Teodor synes det første er lettere å lese.
(set! *print-namespace-maps* false)

(defn db-conn []
  (let [uri (str "datomic:mem://" (random-uuid))
        _ (d/create-database uri)
        conn (d/connect uri)]

    ;; First, create the schema.
    ;; We need to create the schema before inserting data.
    (d/transact conn schema)

    ;; Then, create the author.
    ;; We want to be able to refer back to the author from books.
    @(d/transact conn [{:goodreads/id 38550
                        :goodreads/title "Brandon Sanderson"
                        :goodreads/type :goodreads.type/author
                        :goodreads/url "https://www.goodreads.com/author/show/38550.Brandon_Sanderson"}])

    ;; Then, create the series.
    ;; We want to refer to a series too.
    @(d/transact conn [{:goodreads/id 49075
                        :goodreads/title "The Stormlight Archive"
                        :goodreads/type :goodreads.type/series
                        :goodreads/url "https://www.goodreads.com/series/49075-the-stormlight-archive"}])

    ;; Then, add some books.
    ;; Books are written by an author, and are part of a series.
    (let [sanderson [:goodreads/id 38550]
          stormlight [:goodreads/id 49075]
          books [{:title "The Way of Kings" :id 7235533 :url "https://www.goodreads.com/book/show/7235533-the-way-of-kings"}
                 {:title "Words of Radience" :id 17332218 :url "https://www.goodreads.com/book/show/17332218-words-of-radiance"}]
          book->datomic (fn [book]
                          {:goodreads/id (:id book)
                           :goodreads/title (:title book)
                           :goodreads/type :goodreads.type/book
                           :goodreads/url "https://www.goodreads.com/book/show/7235533-the-way-of-kings"
                           :goodreads/author [sanderson]
                           :goodreads/series [stormlight]})]
      (d/transact conn (map book->datomic books)))

    ;; Finally, return an immutable database.
    conn))

(defn db []
  (d/db (db-conn)))

(comment

  (def mydb (db))

  ;; What authors are there?

  (d/q '[:find ?author ?id
         :where
         [?e :goodreads/type :goodreads.type/author]
         [?e :goodreads/title ?author]
         [?e :goodreads/id ?id]]
       mydb)
  ;; => #{["Brandon Sanderson" 38550]}

  (def sanderson (d/entity mydb [:goodreads/id 38550]))

  (:goodreads/url sanderson)
  ;; => "https://www.goodreads.com/author/show/38550.Brandon_Sanderson"

  ;; what about books?
  ;; we'we modelled book-authors as books referring to an author.
  ;; Datomic allows walking relations "backwards".
  ;; The relation from book to author is :goodreads/author.
  ;; The inverse relation is :_goodreads/author.


  (:goodreads/_author sanderson)
  ;; => #{{:db/id 17592186045422} {:db/id 17592186045423}}

  (map (fn [book]
         {:title (:goodreads/title book)})
       (:goodreads/_author sanderson))
  ;; => ({:title "The Way of Kings"} {:title "Words of Radience"})

  (:goodreads/title (d/entity mydb 17592186045422))
  ;; => "The Way of Kings"

  (:goodreads/title (d/entity mydb 17592186045423))
  ;; => "Words of Radience"

  )
