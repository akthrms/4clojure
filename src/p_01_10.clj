(ns p-01-10)

; #1
; Nothing but the Truth
; Difficulty: Elementary
; Topics:

(= true true)

; #2
; Simple Math
; Difficulty: Elementary
; Topics:

(= (- 10 (* 2 3)) 4)

; #3
; Intro to Strings
; Difficulty: Elementary
; Topics:

(= "HELLO WORLD" (.toUpperCase "hello world"))

; #4
; Intro to Lists
; Difficulty: Elementary
; Topics:

(= (list :a :b :c) '(:a :b :c))

; #5
; Lists: conj
; Difficulty: Elementary
; Topics:

(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))

; #6
; Intro to Vectors
; Difficulty: Elementary
; Topics:

(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

; #7
; Vectors: conj
; Difficulty: Elementary
; Topics:

(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

; #8
; Intro to Sets
; Difficulty: Elementary
; Topics:

(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

; #9
; Sets: conj
; Difficulty: Elementary
; Topics:

(= #{1 2 3 4} (conj #{1 4 3} 2))

; #10
; Intro to Maps
; Difficulty: Elementary
; Topics:

(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))
