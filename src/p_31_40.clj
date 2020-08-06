(ns p-31-40)

; #31
; Pack a Sequence
; Difficulty: Easy
; Topics: seqs

(= (partition-by identity [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (partition-by identity [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (partition-by identity [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

; #32
; Duplicate a Sequence
; Difficulty: Easy
; Topics: seqs

(= (mapcat #(list % %) [1 2 3]) '(1 1 2 2 3 3))
(= (mapcat #(list % %) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (mapcat #(list % %) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (mapcat #(list % %) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

; #33
; Replicate a Sequence
; Difficulty: Easy
; Topics: seqs

(= (#(mapcat (fn [x] (repeat %2 x)) %1) [1 2 3] 2) '(1 1 2 2 3 3))
(= (#(mapcat (fn [x] (repeat %2 x)) %1) [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= (#(mapcat (fn [x] (repeat %2 x)) %1) [4 5 6] 1) '(4 5 6))
(= (#(mapcat (fn [x] (repeat %2 x)) %1) [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= (#(mapcat (fn [x] (repeat %2 x)) %1) [44 33] 2) [44 44 33 33])

; #34
; Implement range
; Difficulty: Easy
; Topics: seqs core-functions

(= (#(take (- %2 %1) (iterate inc %1)) 1 4) '(1 2 3))
(= (#(take (- %2 %1) (iterate inc %1)) -2 2) '(-2 -1 0 1))
(= (#(take (- %2 %1) (iterate inc %1)) 5 8) '(5 6 7))

; #35
; Local bindings
; Difficulty: Elementary
; Topics: syntax

(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3, y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))
