(ns p-61-70)

; #61
; Map Construction
; Difficulty: Easy
; Topics: core-functions

(= (#(apply hash-map (interleave %1 %2)) [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
(= (#(apply hash-map (interleave %1 %2)) [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
(= (#(apply hash-map (interleave %1 %2)) [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})

; #62
; Re-implement Iterate
; Difficulty: Easy
; Topics: seqs core-functions

(= (take 5 ((fn my-iterate [f init] (lazy-seq (cons init (my-iterate f (f init))))) #(* 2 %) 1)) [1 2 4 8 16])
(= (take 100 ((fn my-iterate [f init] (lazy-seq (cons init (my-iterate f (f init))))) inc 0)) (take 100 (range)))
(= (take 9 ((fn my-iterate [f init] (lazy-seq (cons init (my-iterate f (f init))))) #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))

; #63
; Group a Sequence
; Difficulty: Easy
; Topics: core-functions

(= (#(apply merge-with into (for [x %2] {(%1 x) [x]})) #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
(= (#(apply merge-with into (for [x %2] {(%1 x) [x]})) #(apply / %) [[1 2] [2 4] [4 6] [3 6]]) {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
(= (#(apply merge-with into (for [x %2] {(%1 x) [x]})) count [[1] [1 2] [3] [1 2 3] [2 3]]) {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

; #64
; Intro to Reduce
; Difficulty: Elementary
; Topics: seqs

(= 15 (reduce + [1 2 3 4 5]))
(= 0 (reduce + []))
(= 6 (reduce + 1 [2 3]))
