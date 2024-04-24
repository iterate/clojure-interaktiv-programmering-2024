(ns heiclojure.dag2
  (:require
   [datomic.api :as d]
   [heiclojure.dag2.books :as books]))

(set! *print-namespace-maps* false)

(def db (books/db))

;; Cheat sheet: dette er attributtene vi har i bok-databasen vår:
(map :db/ident books/schema)
;; => (:goodreads/id
;;     :goodreads/url
;;     :goodreads/type
;;     :goodreads/title
;;     :goodreads/author
;;     :goodreads/series)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; list ut alle forfattere med en datalog-spørring
;;
;; datalog-spørringer: https://docs.datomic.com/pro/getting-started/query-the-data.html

(d/q '[:find ?title ?url
       :where
       [?e :goodreads/title ?title]
       [?e :goodreads/url ?url]
       [?e :goodreads/type :goodreads.type/author]]
     db)

:TODO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; finn Goodreads-linken til Brandon Sanderson i databasen med en datalog-spørring

;; alt 1: via goodreads id
;;
;; goodreads id: 38550

(d/q '[:find ?title ?url
       :where
       [?e :goodreads/title ?title]
       [?e :goodreads/url ?url]
       [?e :goodreads/id 38550]
       [?e :goodreads/type :goodreads.type/author]]
     db)

;; alt 2: via navn

(d/q '[:find ?url
       :where
       [?e :goodreads/title "Brandon Sanderson"]
       [?e :goodreads/url ?url]
       [?e :goodreads/type :goodreads.type/author]]
     db)

:TODO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; finn bøkene Brandon Sanderson har skrevet med en datalog-spørring

;; => (:goodreads/id
;;     :goodreads/url
;;     :goodreads/type
;;     :goodreads/title
;;     :goodreads/author
;;     :goodreads/series)

(d/q '[:find ?title ?url
       :where
       [?e :goodreads/title ?title]
       [?e :goodreads/url ?url]
       [?e :goodreads/type :goodreads.type/book]
       [?e :goodreads/type :goodreads.type/author]]
     db)

(d/q '[:find ?author-name ?title
       :where
       [?e :goodreads/type :goodreads.type/book]
       [?e :goodreads/id ?id]
       [?e :goodreads/author ?author]
       [?author :goodreads/title ?author-name]
       [?author :goodreads/title "Brandon Sanderson"]
       [?e :goodreads/title ?title]
       ]
     db)

(into {} (d/entity db [:goodreads/id 38550]))

;; keyword
:hei
:amedia/acp-id
:?amedia/acp-id

;; symboler
'hei
'amedia/teodor
'?amedia/teodor

(def hei 42)
hei

'hei

(eval 'hei)

(def difference (requiring-resolve 'clojure.set/difference))

(difference #{1 2 3} #{2 3 4})

'(let [x 3] x)
(type (first (second '(let [x 3] x))))

(:x {:x 1 :y 2})
(get {'x 1 'y 2} 'x)
(get {"x" 1 "y" 2} "x")


(map :y
     [{:x 1 :y 2} {:x 10 :y 20}])

:TODO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; Hent ut Brandon Sanderson som en _entity_
;;
;; Dokumentasjon for datomic.api/entity:
;; https://docs.datomic.com/pro/clojure/index.html#datomic.api/entity

:TODO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; Hent så ut bøkene Sanderson har skrevet med en revers-lookup fra entity.
;;
;; revers-lookup: når :person/liker peker fra en person til ting personen liker,
;; peker :person/_liker fra en ting til personer som liker den tingen.

:TODO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; Legg så inn bøkene fra _The Stormlight Archive_ som mangler!
;;
;; Sjekk :goodreads/url for serien de første bøkene er del av

:TODO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; Finn deretter et databasetidspunkt _før_ de nye Stormlight-bøkene ble lagt
;; til, og _etter_ de ble lagt til.
;;
;; - Bruk datomic.api/as-of til å scrolle tilbake i tid
;;
;; - List opp tittelen til alle bøkene i serien _før_ de nye ble lagt til, og
;;   _etter_ de nye ble lagt til
;;
;; Guide for å scrolle i tid med Datomic:
;;
;; https://docs.datomic.com/pro/tutorial/history.html

:TODO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; - Finn en måte å modellere _året_ bøkene har blitt sluppet
;;
;; - Legg til året bøkene har blitt sluppet for hver enkelt bok

:TODO








































;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; TEODOR JUKSELAPP VELDIG HEMMELIG


(d/q '[:find ?title
       :where [?e :goodreads/title ?title]]
     db)
;; => #{["The Stormlight Archive"] ["Words of Radience"] ["Brandon Sanderson"] ["The Way of Kings"]}
