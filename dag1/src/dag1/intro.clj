(ns dag1.intro)

;; En bitteliten intro til Clojure syntaksen
;; Or: How I Learned To Stop Worrying And Love The Parenthesis


;; OPERATORER
;; 3 + 4
(+ 3 4)

;; DEFINERE KONSTANTER
;; Eksempler fra JS:
;; const a = 5

(def a 5)

;; KALLE PÅ KONSTANTER
;; Eksempler fra JS:
;; a

a

;; DEFINERE FUNKSJONER
;; Eksempler fra JS:

;; function squared(p) {
;;  return p * p;
;; }

;; const squared = (p) => {
;;     return p * p
;; }

(defn squared [p]
  (* p p))

;; KALLE FUNKSJONER
;; Eksempler fra JS:
;; squared(a)

(squared a)