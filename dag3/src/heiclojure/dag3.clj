;; # Introduksjon til Clerk! 🎉

(ns heiclojure.dag3
  (:require
   [nextjournal.clerk :as clerk]))

;; ## clerk/table

(def data
  (repeatedly 10000
              (fn []
                {:value (rand-int 1000)
                 :navn (rand-nth ["Richard" "Magnus"])})))

(clerk/table data)

;; ## clerk/html

^{:nextjournal.clerk/visibility {:code :hide}}
(clerk/html
 "<p>potetstappe</p>")

^{:nextjournal.clerk/visibility {:code :fold :result :show}}
(clerk/html [:p "potetstappe"])

;; ## clerk/vl

(clerk/vl
 {"$schema" "https://vega.github.io/schema/vega-lite/v5.json",
  "description" "A simple bar chart with embedded data.",
  "data" {"values" [{"a" "A", "b" 28}, {"a" "B", "b" 55}, {"a" "C", "b" 43},
                    {"a" "D", "b" 91}, {"a" "E", "b" 81}, {"a" "F", "b" 53},
                    {"a" "G", "b" 19}, {"a" "H", "b" 87}, {"a" "I", "b" 52}]},
  "mark" "bar",
  "encoding" {"x" {"field" "a", "type" "nominal", "axis" {"labelAngle" 0}},
              "y" {"field" "b", "type" "quantitative"}}})

(clerk/vl
 {:data {:values [{:a "A", "b" 28}, {"a" "B", "b" 55}, {"a" "C", "b" 43}]}
  :mark :bar
  :encoding {"x" {"field" "a", "type" "nominal", "axis" {"labelAngle" 0}}
             "y" {"field" "b", "type" "quantitative"}}})

;; ## clerk/caption
(clerk/caption "Figur 1: A-er og B-er i stolpediagram"
               (clerk/vl
                {:data {:values [{:a "A", "b" 28}, {"a" "B", "b" 55}, {"a" "C", "b" 43}]}
                 :mark :bar
                 :encoding {"x" {"field" "a", "type" "nominal", "axis" {"labelAngle" 0}}
                            "y" {"field" "b", "type" "quantitative"}}}))

(clerk/caption "mitt avsnitt"
               (clerk/html [:p "potetstappe"]))

(clerk/table [{:hva "vise caption"
               :demo
               (clerk/caption "mitt avsnitt"
                              (clerk/html [:p "potetstappe"]))}])

(clerk/caption "Eksempel med clerk/html"
               (clerk/code '(clerk/html [:p "potetstappe"])))

[:nr-1 :nr-2 1 2 3 4 5]

^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(comment
  ;; ignoreret!

  )

^{:nextjournal.clerk/visibility {:code :hide}}
(clerk/html [:div {:style {:height "50vh"}}])
