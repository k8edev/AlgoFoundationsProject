(ns src.clojuredemo.core)

(defn tail-recursive-fibonacci
  "Tail-recursive version of the Fibonacci sequence."
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

(defn recursive-fibonacci
  "Recursive implementation of the Fibonacci sequence."
  [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (recursive-fibonacci (- n 1))
             (recursive-fibonacci (- n 2)))))

(defn tail-recursive-factorial
  "Tail-recursive implementation of the factorial algorithm"
  [n]
  (loop [current n
         next (dec current)
         total 1]
    (if (> current 1)
      (recur next (dec next) (* total current))
      total)))

(defn recursive-factorial
  "Recursive implementation of the factorial algorithm"
  [n]
  (if (= n 1)
    1
    (* n (recursive-factorial (- n 1)))))

