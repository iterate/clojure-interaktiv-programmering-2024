# Interaktiv programmering med Clojure: dag 2

Velkommen!

[![Land of Lisp music video](https://img.youtube.com/vi/HM1Zb3xmvMc/0.jpg)](https://www.youtube.com/watch?v=HM1Zb3xmvMc)

## 0α, Literate Programming

https://en.wikipedia.org/wiki/Literate_programming

## 0β: Interaktiv programmering

https://en.wikipedia.org/wiki/Interactive_programming

## 0γ: Clerk: et verktøy for iteraktiv _og_ literate programming

| Hva                            | URL                        |
|--------------------------------|----------------------------|
| Nettside                       | https://clerk.vision/      |
| Dokumentasjon                  | https://book.clerk.vision/ |
| Vitenskaplig artikkel fra 2023 | https://px23.clerk.vision/ |

## 1β: Læringsmål

(optimistisk!)

Clojure:

- Få prøvd interaktiv programmering.
- Få prøvd Clojure.
- Få med seg noen ideer som man kan bruke i andre språk.

Clerk:

- Klare å starte Clerk fra REPL
- Vite hvordan man kan kjøre clerk
  - Med file watcher
  - Med tastatursnarvei
- Vite at Clerk evaluerer hele filer (ikke bare ett uttrykk)
- Vite at Clerk gjør caching av uttrykk
  - Trøbbel med java-objekter (som Playwright)
  - Men veldig bra for data science
- Vite hvordan Clerk viser og evaluerer Clojure-uttrykk
- Vite hvordan Clerk viser markdown i kommentarer
- Kjenne noen Clerk-funksjoner
  - clerk/serve
  - clerk/table
  - clerk/html
  - clerk/vl
  - clerk/caption
  - clerk/fragment

## 2: Demo

Oppfordring:

- Len dere tilbake og se på :)
- Dere får prøve selv etterpå.
- Jeg ønsker å vise _hva Clerk er_ før dere begynner å bruke Clerk.

Funksjoner jeg ønsker å dekke:

- clerk/table
- clerk/html
- clerk/vl
- clerk/caption
- clerk/fragment

## 3: Prøv Clerk selv

``` clojure
{:deps {io.github.nextjournal/clerk {:mvn/version "0.15.957"}}}
```

Starte Clerk med file watcher (kode i navnerom):

``` clojure
(ns DITT_NAVNEROM
  (:require [nextjournal.clerk :as clerk]))

(comment
  (clerk/serve {:browse? true :watch-paths ["src"]}))
```

Starte Clerk med file watcher (fra REPL-vinduet):

``` clojure
(require '[nextjournal.clerk :as clerk])

(clerk/serve {:browse? true :watch-paths ["src"]})
```

## 4: Egne oppgaver

Kanskje du kan bruke Clerk til å løse noe du _ønsker_ å løse?
