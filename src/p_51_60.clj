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
