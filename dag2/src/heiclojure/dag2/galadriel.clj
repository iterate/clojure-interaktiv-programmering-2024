(ns heiclojure.dag2.galadriel
  {:authors ["Isak" "Richard" "Ruben"]}
  (:require
   [datomic.api :as d]
   [heiclojure.dag2.books :as books]))

(set! *print-namespace-maps* false)

(def db (books/db))

;; Cheat sheet: dette er atributtene vi har i bok-databasen vår:
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

:TODO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; finn Goodreads-linken til Brandon Sanderson i databasen med en datalog-spørring

:TODO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; OPPGAVE
;;
;; finn bøkene Brandon Sanderson har skrevet med en datalog-spørring

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
