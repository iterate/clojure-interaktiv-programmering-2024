(ns heiclojure.dag3.jukselapp
  (:require
   [nextjournal.clerk :as clerk]
   [nextjournal.clerk.viewer :as v]
   [clojure.edn :as edn]))

;; ## Prior work: list pages & put into db

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn big-table [x]
  (v/with-viewer (dissoc v/table-viewer :page-size)
    x))

(def acpids ["5-55-1653975"
             "5-76-2283446"
             "5-95-1667990"
             "5-95-1680177"
             "5-95-1680308"
             "5-128-744550"])

(defn read-content-version [acpid]
  (let [path (str "../data/" acpid "/history.edn")]
    (edn/read-string (slurp path))))

(let [acpid (first acpids)]
  (read-content-version acpid))

(clerk/table (let [acpid (first acpids)]
               (read-content-version acpid)))

(defn all-versions []
  (mapcat read-content-version acpids))

^{:nextjournal.clerk/auto-expand-results? true ::clerk/width :full}
(big-table (all-versions))

(clerk/html "<strong> hei </strong>")

(clerk/html [:strong "hei"])

(defn count-versions []
  (->> (all-versions)
       (group-by :acp_id)
       (map (fn [[k v]] {:acpid k :count (count v)}))))

(clerk/vl
 {
  :width 600
  :height 300
  :data {:values
         (count-versions)}
  :mark :bar
  :encoding {:x {:field :acpid :type :nominal :axis {:labelAngle 0}}
             :y {:field :count :type :quantitative}}})

^{:nextjournal.clerk/visibility {:code :hide}}
(clerk/html [:div {:style {:height "50vh"}}])
