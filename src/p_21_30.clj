(ns p-21-30)

; #21
; Nth Element
; Difficulty: Easy
; Topics: seqs core-functions

(= (#(get (vec %1) %2) '(4 5 6 7) 2) 6)
(= (#(get (vec %1) %2) [:a :b :c] 0) :a)
(= (#(get (vec %1) %2) [1 2 3 4] 1) 2)
(= (#(get (vec %1) %2) '([1 2] [3 4] [5 6]) 2) [5 6])

; #22
; Count a Sequence
; Difficulty: Easy
; Topics: seqs core-functions

(= (#(reduce (fn [cnt _] (+ cnt 1)) 0 %) '(1 2 3 3 1)) 5)
(= (#(reduce (fn [cnt _] (+ cnt 1)) 0 %) "Hello World") 11)
(= (#(reduce (fn [cnt _] (+ cnt 1)) 0 %) [[1 2] [3 4] [5 6]]) 3)
(= (#(reduce (fn [cnt _] (+ cnt 1)) 0 %) '(13)) 1)
(= (#(reduce (fn [cnt _] (+ cnt 1)) 0 %) '(:a :b :c)) 3)

; #23
; Reverse a Sequence
; Difficulty: Easy
; Topics: seqs core-functions

(= (#(reduce (fn [xs x] (cons x xs)) () %) [1 2 3 4 5]) [5 4 3 2 1])
(= (#(reduce (fn [xs x] (cons x xs)) () %) (sorted-set 5 7 2 7)) '(7 5 2))
(= (#(reduce (fn [xs x] (cons x xs)) () %) [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])

; #24
; Sum It All Up
; Difficulty: Easy
; Topics: seqs

(= (#(reduce + %) [1 2 3]) 6)
(= (#(reduce + %) (list 0 -2 5 5)) 8)
(= (#(reduce + %) #{4 2 1}) 7)
(= (#(reduce + %) '(0 0 -1)) -1)
(= (#(reduce + %) '(1 10 3)) 14)

; #25
; Find the odd numbers
; Difficulty: Easy
; Topics: seqs

(= (filter #(not (= 0 (mod % 2))) #{1 2 3 4 5}) '(1 3 5))
(= (filter #(not (= 0 (mod % 2))) [4 2 1 6]) '(1))
(= (filter #(not (= 0 (mod % 2))) [2 2 4 6]) '())
(= (filter #(not (= 0 (mod % 2))) [1 1 1 3]) '(1 1 1 3))

; #26
; Fibonacci Sequence
; Difficulty: Easy
; Topics: Fibonacci seqs

(= (#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 3) '(1 1 2))
(= (#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 6) '(1 1 2 3 5 8))
(= (#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 8) '(1 1 2 3 5 8 13 21))

; #27
; Palindrome Detector
; Difficulty: Easy
; Topics: seqs

(false? (#(= (seq %) (seq (reverse %))) '(1 2 3 4 5)))
(true? (#(= (seq %) (seq (reverse %))) "racecar"))
(true? (#(= (seq %) (seq (reverse %))) [:foo :bar :foo]))
(true? (#(= (seq %) (seq (reverse %))) '(1 1 3 3 1 1)))
(false? (#(= (seq %) (seq (reverse %))) '(:a :b :c)))

; #28
; Flatten a Sequence
; Difficulty: Easy
; Topics: seqs core-functions

(= (#(filter (complement sequential?) (rest (tree-seq sequential? seq %))) '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (#(filter (complement sequential?) (rest (tree-seq sequential? seq %))) ["a" ["b"] "c"]) '("a" "b" "c"))
(= (#(filter (complement sequential?) (rest (tree-seq sequential? seq %))) '((((:a))))) '(:a))
