# Interaktiv programmering med Clojure: dag 1

[![SICP intro jingle](https://img.youtube.com/vi/3NqnZZR3S20/0.jpg)](https://www.youtube.com/watch?v=3NqnZZR3S20)

## Målgruppe

Skriv liste over alle deltagere her, og hvilken editor de bruker.

- Olav (TA, mac+vscode)
- Richard (VSCode? Intellij?)
- Teodor (VSCode/Emacs)

## Agenda

1. DEMO REPL-dreven utvikling med HTTP-server (motivasjon) (5 min)
2. Installasjonsinstruksjoner (5 min)
   - VSCode & Calva & java & clj - på mac?
   - Alle er oppe og kjøre med en REPL
3. REPL - java og clojure-verktøyet
   - REPL & intro til Clojure-syntax. (olav)
       - sammenlikne clojure og js
       - pluss og minus
   - assert
   - flere oppgaver
   - kanskje introdusere filer først nå
   - Skrive funksjoner
   - som opererer på data
   - lese EDN-fil
     - slurp og clojure.edn/read-string
   - ende opp med en http-server ("nice to have")
     - (fn [req] {:status 200})
 
## Pensum

### Teori

- keywords, strings, numbers
- datastrukturer: , vektorer, sets og maps
  - alle er immutable!
- slå opp dokumentasjon
   - I REPL: (doc map)
   - https://clojuredocs.org/ -- kjempegode eksempler.

### funksjoner

- str
- map, filter
- into
- slurp
- clojure.edn/read-string
- count
- =

### viktige konsepter

- def, defn, fn
- navnerom og ns-formen
- keywords er funksjoner som slår seg selv opp i maps
- cond, if
- assert

### kanskje

- ->> (lister)
- let
- #(,,, %)
- when
- reduce
- lister (optional)

### helt sikkert ikke nødvendig men litt kult

- implementere eval med postwalk
- destructuring
- if-let, when-let
- -> (objekter)
