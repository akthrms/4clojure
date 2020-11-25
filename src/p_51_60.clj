(ns p-51-60)

; #51
; Advanced Destructuring
; Difficulty: Easy
; Topics: destructuring

(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))

; #52
; Intro to Destructuring
; Difficulty: Elementary
; Topics: destructuring

(= [2 4] (let [[a b c d e] [0 1 2 3 4]] [c e]))

; #53
; Longest Increasing Sub-Seq
; Difficulty: Hard
; Topics: seqs

(defn longest-increasing-sub-seq [nums]
  (let [sub-seq (fn [ns]
                  (let [[h & t] ns
                        new-ns (reduce #(if (= %2 (inc (last %1))) (conj %1 %2) (reduced %1)) [h] t)]
                    (if (< 1 (count new-ns)) new-ns [])))]
    (loop [new-nums nums
           result []]
      (if (empty? new-nums)
        result
        (let [new-result (sub-seq new-nums)]
          (recur (rest new-nums) (if (< (count result) (count new-result)) new-result result)))))))

(= (longest-increasing-sub-seq [1 0 1 2 3 0 4 5]) [0 1 2 3])
(= (longest-increasing-sub-seq [5 6 1 3 2 7]) [5 6])
(= (longest-increasing-sub-seq [2 3 3 4 5]) [3 4 5])
(= (longest-increasing-sub-seq [7 6 5 4]) [])

; #54
; Partition a Sequence
; Difficulty: Medium
; Topics: seqs core-functions

(defn partition-seq [n coll]
  (when (and (seq coll) (<= n (count coll)))
    (cons (take n coll) (partition-seq n (drop n coll)))))

(= (partition-seq 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
(= (partition-seq 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
(= (partition-seq 3 (range 8)) '((0 1 2) (3 4 5)))

; #55
; Count Occurrences
; Difficulty: Medium
; Topics: seqs core-functions

(= (#(apply merge-with + (for [x %] {x 1})) [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
(= (#(apply merge-with + (for [x %] {x 1})) [:b :a :b :a :b]) {:a 2, :b 3})
(= (#(apply merge-with + (for [x %] {x 1})) '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})

; #56
; Find Distinct Items
; Difficulty: Medium
; Topics: seqs core-functions

(= (#(reduce (fn [xs x] (if ((set xs) x) xs (conj xs x))) [] %) [1 2 1 3 1 2 4]) [1 2 3 4])
(= (#(reduce (fn [xs x] (if ((set xs) x) xs (conj xs x))) [] %) [:a :a :b :b :c :c]) [:a :b :c])
(= (#(reduce (fn [xs x] (if ((set xs) x) xs (conj xs x))) [] %) '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
(= (#(reduce (fn [xs x] (if ((set xs) x) xs (conj xs x))) [] %) (range 50)) (range 50))

; #57
; Simple Recursion
; Difficulty: Elementary
; Topics: recursion

(= '(5 4 3 2 1) ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))

; #58
; Function Composition
; Difficulty: Medium
; Topics: higher-order-functions core-functions

(defn compose [& fs]
  (fn [& args]
    (let [[h & t] (reverse fs)]
      (reduce #(%2 %1) (apply h args) t))))

(= [3 2 1] ((compose rest reverse) [1 2 3 4]))
(= 5 ((compose (partial + 3) second) [1 2 3 4]))
(= true ((compose zero? #(mod % 8) +) 3 5 7 9))
(= "HELLO" ((compose #(.toUpperCase %) #(apply str %) take) 5 "hello world"))

; #59
; Juxtaposition
; Difficulty: Medium
; Topics: higher-order-functions core-functions

(= [21 6 1] (((fn [& fs] (fn [& arg] (reduce #(conj %1 (apply %2 arg)) [] fs))) + max min) 2 3 5 1 6 4))
(= ["HELLO" 5] (((fn [& fs] (fn [& arg] (reduce #(conj %1 (apply %2 arg)) [] fs))) #(.toUpperCase %) count) "hello"))
(= [2 6 4] (((fn [& fs] (fn [& arg] (reduce #(conj %1 (apply %2 arg)) [] fs))) :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))

; #60
; Sequence Reductions
; Difficulty: Medium
; Topics: seqs core-functions

(defn my-reductions
  ([f coll]
   (my-reductions f (first coll) (rest coll)))
  ([f init coll]
   (cons init (lazy-seq (if (empty? coll)
                          nil
                          (my-reductions f
                                         (apply f (list init (first coll)))
                                         (rest coll)))))))

(= (take 5 (my-reductions + (range))) [0 1 3 6 10])
(= (my-reductions conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
(= (last (my-reductions * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
