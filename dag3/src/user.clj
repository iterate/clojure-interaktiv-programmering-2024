(ns user)

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn clerk-start! []
  (let [clerk-serve (requiring-resolve 'nextjournal.clerk/serve!)
        clerk-port 7625]
    (clerk-serve {:browse? true :port clerk-port})))

;; 1 2 3 4
