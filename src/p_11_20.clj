(ns p-11-20)

; #11
; Maps: conj
; Difficulty: Elementary
; Topics:

(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))

; #12
; Intro to SequencesSolutions
; Difficulty: Elementary
; Topics:

(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

; #13
; Sequences: restSolutions
; Difficulty: Elementary
; Topics:

(= [20 30 40] (rest [10 20 30 40]))

; #14
; Intro to Functions
; Difficulty: Elementary
; Topics:

(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

; #15
; Double DownSolutions
; Difficulty: Elementary
; Topics:

(= (* 2 2) 4)
(= (* 2 3) 6)
(= (* 2 11) 22)
(= (* 2 7) 14)

; #16
; Hello WorldSolutions
; Difficulty: Elementary
; Topics:

(= (#(str "Hello, " % "!") "Dave") "Hello, Dave!")
(= (#(str "Hello, " % "!") "Jenn") "Hello, Jenn!")
(= (#(str "Hello, " % "!") "Rhea") "Hello, Rhea!")

; #17
; Sequences: mapSolutions
; Difficulty: Elementary
; Topics:

(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

; #18
; Sequences: filterSolutions
; Difficulty: Elementary
; Topics:

(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

; #19
; Last ElementSolutions
; Difficulty: Easy
; Topics: seqs core-functions

(= (#(-> % reverse first) [1 2 3 4 5]) 5)
(= (#(-> % reverse first) '(5 4 3)) 3)
(= (#(-> % reverse first) ["b" "c" "d"]) "d")

; #20
; Penultimate ElementSolutions
; Difficulty: Easy
; Topics: seqs

(= (#(-> % reverse (nth 1)) (list 1 2 3 4 5)) 4)
(= (#(-> % reverse (nth 1)) ["a" "b" "c"]) "b")
(= (#(-> % reverse (nth 1)) [[1 2] [3 4]]) [1 2])
