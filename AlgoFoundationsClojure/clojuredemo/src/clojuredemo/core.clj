(ns src.clojuredemo.core)

(defn tail-recursive-fibonacci
  "Tail-recursive version of the fibonacci sequence."
  [n]
  (if (> n 1)
    (loop [x 1
           fib0 0
           fib1 1]
      (if (< x n)
        (recur
          (inc x)
          fib1
          (+ fib0 fib1))
        fib1))
    n))


(defn factorial-using-recur
  "Recursive version of the factorial algorithm"
  [n]
  (loop [current n
         next (dec current)
         total 1]
    (if (> current 1)
      (recur next (dec next) (* total current))
      total)))