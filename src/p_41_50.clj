(ns p-41-50)

; #41
; Drop Every Nth Item
; Difficulty: Easy
; Topics: seqs

(= (#(apply concat (partition-all (dec %2) %2 %1)) [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (#(apply concat (partition-all (dec %2) %2 %1)) [:a :b :c :d :e :f] 2) [:a :c :e])
(= (#(apply concat (partition-all (dec %2) %2 %1)) [1 2 3 4 5 6] 4) [1 2 3 5 6])

; #42
; Factorial Fun
; Difficulty: Easy
; Topics: math

(= (#(apply * (range 1 (inc %))) 1) 1)
(= (#(apply * (range 1 (inc %))) 3) 6)
(= (#(apply * (range 1 (inc %))) 5) 120)
(= (#(apply * (range 1 (inc %))) 8) 40320)

; #43
; Reverse Interleave
; Difficulty: Medium
; Topics: seqs

(= (#(for [i (range %2)] (take-nth %2 (drop i %1))) [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (#(for [i (range %2)] (take-nth %2 (drop i %1))) (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (#(for [i (range %2)] (take-nth %2 (drop i %1))) (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

; #44
; Rotate Sequence
; Difficulty: Medium
; Topics: seqs

(= (#(let [n (mod %1 (count %2))] (concat (drop n %2) (take n %2))) 2 [1 2 3 4 5]) '(3 4 5 1 2))
(= (#(let [n (mod %1 (count %2))] (concat (drop n %2) (take n %2))) -2 [1 2 3 4 5]) '(4 5 1 2 3))
(= (#(let [n (mod %1 (count %2))] (concat (drop n %2) (take n %2))) 6 [1 2 3 4 5]) '(2 3 4 5 1))
(= (#(let [n (mod %1 (count %2))] (concat (drop n %2) (take n %2))) 1 '(:a :b :c)) '(:b :c :a))
(= (#(let [n (mod %1 (count %2))] (concat (drop n %2) (take n %2))) -4 '(:a :b :c)) '(:c :a :b))

; #45
; Intro to Iterate
; Difficulty: Easy
; Topics: seqs

(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))

; #46
; Flipping out
; Difficulty: Medium
; Topics: higher-order-functions

(= 3 ((#(fn [& args] (apply % (reverse args))) nth) 2 [1 2 3 4 5]))
(= true ((#(fn [& args] (apply % (reverse args))) >) 7 8))
(= 4 ((#(fn [& args] (apply % (reverse args))) quot) 2 8))
(= [1 2 3] ((#(fn [& args] (apply % (reverse args))) take) [1 2 3 4 5] 3))

; #47
; Contain Yourself
; Difficulty: Easy
; Topics:

(contains? #{4 5 6} 4)
(contains? [1 1 1 1 1] 4)
(contains? {4 :a 2 :b} 4)
(not (contains? [1 2 4] 4))

; #48
; Intro to some
; Difficulty: Easy
; Topics:

(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))

; #49
; Split a sequence
; Difficulty: Easy
; Topics: seqs core-functions

(= (#(list (take %1 %2) (drop %1 %2)) 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
(= (#(list (take %1 %2) (drop %1 %2)) 1 [:a :b :c :d]) [[:a] [:b :c :d]])
(= (#(list (take %1 %2) (drop %1 %2)) 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])

; #50
; Split by Type
; Difficulty: Medium
; Topics: seqs

(= (set ((comp vals (partial group-by type)) [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
(= (set ((comp vals (partial group-by type)) [:a "foo" "bar" :b])) #{[:a :b] ["foo" "bar"]})
(= (set ((comp vals (partial group-by type)) [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
