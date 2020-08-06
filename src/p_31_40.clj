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

; #36
; Let it Be
; Difficulty: Elementary
; Topics: math syntax

(= 10 (let [x 7 y 3 z 1] (+ x y)))
(= 4 (let [x 7 y 3 z 1] (+ y z)))
(= 1 (let [x 7 y 3 z 1] z))

; #37
; Regular Expressions
; Difficulty: Elementary
; Topics: regex syntax

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

; #38
; Maximum value
; Difficulty: Easy
; Topics: core-functions

(= ((fn [& xs] (reduce #(if (> %1 %2) %1 %2) xs)) 1 8 3 4) 8)
(= ((fn [& xs] (reduce #(if (> %1 %2) %1 %2) xs)) 30 20) 30)
(= ((fn [& xs] (reduce #(if (> %1 %2) %1 %2) xs)) 45 67 11) 67)

; #39
; Interleave Two Seqs
; Difficulty: Easy
; Topics: seqs core-functions

(= (mapcat list [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (mapcat list [1 2] [3 4 5 6]) '(1 3 2 4))
(= (mapcat list [1 2 3 4] [5]) [1 5])
(= (mapcat list [30 20] [25 15]) [30 25 20 15])

; #40
; Interpose a Seq
; Difficulty: Easy
; Topics: seqs core-functions

(= (#(butlast (mapcat (fn [x] (list x %1)) %2)) 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (#(butlast (mapcat (fn [x] (list x %1)) %2)) ", " ["one" "two" "three"])) "one, two, three")
(= (#(butlast (mapcat (fn [x] (list x %1)) %2)) :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
