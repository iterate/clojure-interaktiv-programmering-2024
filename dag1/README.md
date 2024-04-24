# Interaktiv programmering med Clojure: dag 1

Velkommen!

[![SICP intro jingle](https://img.youtube.com/vi/3NqnZZR3S20/0.jpg)](https://www.youtube.com/watch?v=3NqnZZR3S20)

## 1α: hva skjer i kurset?

| Del   | Dag     | Innhold                                                       |
|-------|---------|--------------------------------------------------------|
| Del 1 | Tirsdag | Trene på interaktiv programmering med REPL             |
| Del 2 | Onsdag  | Bruke databasen Datomic - den kan scrolle i tid!       |
| Del 3 | Torsdag | Bruke verktøyet Clerk til interaktiv datavisualisering |

Hver dag:

- Felles opplegg 09:00-10:00.
  Fysisk og remote.
- Vi blir lenger i rommet hvis vi har anledning, hjelper gjerne folk som vil prøve mer!
- Still spørsmål i #clojure på Slack hvis du lurer på noe!
  Vi følger med så godt vi kan.
  Gi oss eventuelt en @teodor eller @olav eller @ruben hvis du ikke får svar!

Oppfordringer:

- Still spørsmål hvis du lurer på noe!
  Sannsynligvis sitter flere med det samme spørsmålet.
  Og _noen_ av oss bør kunne gi deg et okei svar.
  Ingen spørsmål er dumme, dette er helt nytt for mange!
- Vi har *supergod* dekning på studasser, vi er tre som kan Clojure og seks som ønsker å lære.
  Bruk det!

## 1β: Læringsmål

- Få prøvd interaktiv programmering.
- Få prøvd Clojure.
- Få med seg noen ideer som man kan bruke i andre språk.

## 1A: Demo, interaktiv programmering

## 1B: Installasjon av miljø

Se [INSTALL.md].

[INSTALL.md]: INSTALL.md

## 1C: Introduksjon til REPL og Clojure-syntaks (Olav)

[Superenkel intro til Clojure syntaksen](https://github.com/amedia/teod/blob/master/faguke-2024-clojure-interaktiv-programmering/dag1/src/dag1/intro.clj)

## 1D: hent innholdstilstand (`:content_state`) for den første versjonen av `5-55-1653975`

(tror Olav har dekket `def` og `defn`).

Demonstrasjon:

0. Sett `acp-id` til 5-55-1653975 (bruk def)
1. `str`: for å slå sammen strings
2. `slurp`: for å lese en fil
3. `clojure.edn/read-string`: konverter en string til Clojure-data
4. Sett `history` til historien til 5-55-1653975 (bruk def)

Oppgaver:

1. Hva er `:content_state` for den første versjonen av `5-55-1653975`? (bruk `first` og REPL)
2. Hvor mange versjoner finnes det for `5-55-1653975`? (bruk `count` og REPL)

## 1E: Keywords og maps i Clojure

Demonstrasjon:

``` clojure
;; keyword:

:name

;; map:

(def person {:name "Teodor" :age 33})
```

Vi kan bruke keywords til å slå opp verdier fra et map.

``` clojure
(:name person)
;; => "Teodor"

(:age person)
;; => 33
```

Oppgaver:

1. Hent `:version_id` for den første versjonen av `5-55-1653975`.
2. Hent `:version_id` for den siste versjonen av `5-55-1653975`. (bruk `last`)

## Interlude: hva liker Teodor med Clojure?

Viktige grunner:

1. God støtte for interaktiv programmering (det vi gjør nå, evaluere uttrykk i REPL og se hva som kommer ut)
2. Tilgang på Java-økosystemet (JVM Clojure) eller Javascript-økosystemet (Clojurescript)

Nice to haves:

3. God støtte for å transformere immutable data (data literals for maps, sets og vektorer, keywords, funksjoner som opererer på maps og lister)
4. God støtte for navn (navnerom[1], symboler², keywords³, vars⁴)

¹Clojure-filen dere jobber i nå er ett navnerom.

²symboler har vi ikke sett på ennå.

³feks `:name`.

⁴du lager en var når du bruker `def` eller `defn`, men du kan ignorere at disse er for nå.

## 1F: Sets og vektorer i Clojure

Demonstrasjon:

``` clojure
;; vektor:

[1 2 3]

;; set: ("sett", kun unike elementer)

#{1 2 3}

;; konvertere fra vektor til set:

(into #{} [1 2 3])
konvertere fra set til vektor:

(into [] #{1 2 3})
```

Oppgaver:

1. Hva skjer når du evaluerer `[1 2 1]`?
2. Hva skjer når du evaluerer `#{1 2 1}`?

## 1G: `map`

Demonstrasjon:

``` clojure
;; inc øker med én ("increase")
(inc 1)

;; la oss øke alle tallene med én.
(map inc [1 2 3])

;; la oss hente ut navn for alle personene!
(def instructors
  [{:name "Olav" :age 123}
   {:name "Ruben" :age 456}
   {:name "Teodor" :age 33}])

(map :name instructors)
```

3. Hent ut forfatter for alle versjoner av `5-55-1653975`.
4. Hent ut _unike forfattere_ for alle versjoner av `5-55-1653975`.
5. Hent ut antall unike

## --- (vi kommer nok ikke gjennom alt) ---

## 1H: Sjekk om alle versjoner har samme forfatter

Du trenger: `count`.

## 1I: Gi tidspunkt og forfatter for hver versjon

## 1J: Gi tidspunkt for første og siste versjon

Returner en vektor, feks

``` clojure
["2024-03-02 16:19:11.116"
 "2024-03-02 18:23:50.127"]
```

med første og siste versjon.

## 1K: Sjekk om alle historie-dump-filene til Ruben er sortert etter `:version_timestamp`

Denne oppgaven er større enn oppgavene over, gi deg selv nok tid!

Du finner en dump av historien til flere ACP-ID-er her:
https://github.com/amedia/teod/tree/5af3393c668cff5d26a3f1a8c9e339a6d0f81739/faguke-2024-clojure-interaktiv-programmering/data/

Funksjoner du kanskje trenger:

- `=` for å sjekke om to ting er like
- `assert` for å krasje når du gir andre verdier enn `true`
- `(sort-by f history)` for å sortere etter returverdien til funksjonen `f`
  - Husk at keywords kan brukes som funksjoner!

