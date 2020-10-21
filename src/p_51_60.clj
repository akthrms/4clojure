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
