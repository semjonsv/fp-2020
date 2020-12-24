;; 1. Find the last element of a list.
(defn my-last [xs]
  (let
   [[start & end] xs]
    (if (empty? end)
      start
      (recur end))))

(assert (= :d
           (my-last '(:a :b :c :d))))

;; 2. Find the N-th element of a list.
(defn get-nth [xs n]
  (if (= n 0)
    (first xs)
    (get-nth (rest xs) (dec n))))

(assert (= :c
           (get-nth '(:a :b :c :d) 2)))

;; 3. Find the length of a list
(defn my-length [xs]
  (if (empty? xs) 0
      (+ 1 (my-length (next xs)))))

(assert (= 4
           (my-length '(:a :b :c :d))))

;; 4. Reverse a list.
(defn my-reverse [xs]
  (loop [xs xs
         response []]
    (if (empty? xs)
      response
      (recur (rest xs) (cons (first xs) response)))))

(assert (= '(:d :c :b :a)
           (my-reverse '(:a :b :c :d))))

;; 5. Find out whether a list is a palindrome.
(defn is-palindrome? [xs]
  (if (= xs (loop [xs xs
                   response []]
              (if (empty? xs)
                response
                (recur (rest xs) (cons (first xs) response)))))
    true
    false))

(assert (= true
           (is-palindrome? '(:a :b :c :b :a))))

;; 6. Duplicate the elements of a list.
(defn duplicate [xs]
  (flatten
   (for [i xs]
     (repeat 2 i))))

(assert (= '(:a :a :b :b :c :c)
           (duplicate '(:a :b :c))))

;; 7. Eliminate consecutive duplicates of a list.
(defn compress [xs]
  (when (seq xs)
    (if (= (first xs) (first (next xs)))
      (compress (next xs))
      (cons (first xs) (compress (next xs))))))

(assert (= '(:a :b :c)
           (compress '(:a :a :b :b :c :c))))

;; 8. Remove the N-th element of a list
(defn remove-at [xs n]
  (when (seq xs)
    (if (= 0 n)
      (next xs)
      (cons (first xs) (remove-at (next xs) (dec n))))))

(assert (= '(:a :b :d :e)
           (remove-at '(:a :b :c :d :e) 2)))

;; 9. Insert a new element at the N-th position of a list.
(defn insert-at [x xs n]
  (if (= 0 n) (cons x xs)
      (cons (first xs) (insert-at x (next xs) (dec n)))))

(assert (= '(:a :b :x :c :d)
           (insert-at :x '(:a :b :c :d) 2)))

;; 10. Create a list containing all integers within a given range.
(defn my-range [a b]
  (loop [b b
         response []]
    (if (= b a)
      (cons a response)
      (recur (dec b) (cons b response)))))

(assert (= '(3 4 5 6 7)
           (my-range 3 7)))

;; 11. Concatenate two lists
(defn my-concat [xs ys]
  (loop [xs xs
         response ys]
    (if (empty? xs)
      response
      (recur (drop-last xs) (cons (last xs) response)))))

(assert (= '(:a :b :c :d :e :f)
           (my-concat '(:a :b :c) '(:d :e :f))))

;; 12. Split a list into two parts; the length of the first part is given.
(defn my-drop [xs n]
  (if (= n 0) xs
      (my-drop (next xs) (dec n))))

(assert (= '(:d :e)
           (my-drop '(:a :b :c :d :e) 3)))

;; 13. Split a list into two parts; the length of the first part is given.
(defn my-take [xs n]
  (when (seq xs)
    (if (= n 0) []
        (cons (first xs) (my-take (next xs) (dec n))))))

(assert (= '(:a :b :c)
           (my-take '(:a :b :c :d :e) 3)))

;; 14. Implement the filtering function
(defn my-filter [p xs]
  (when (seq xs)
    (if (p (first xs))
      (cons (first xs)
            (my-filter p (next xs)))
      (my-filter p (next xs)))))

(assert (= '(1 3 5)
           (my-filter odd? '(1 2 3 4 5))))

;; 15. Implement the mapping function
(defn my-map [f xs]
  (when (seq xs)
    (cons (f (first xs))
          (my-map f (next xs)))))

(assert (= '(2 3 4 5 6)
           (my-map inc '(1 2 3 4 5))))

;; 16. Implement the reducing function
(defn my-reduce [f acc xs]
  (if (seq xs)
    (f (first xs) (my-reduce f acc (next xs)))
    acc))

(assert (= 15
           (my-reduce + 0 '(1 2 3 4 5))))

;; 17. Implement the flattening function
(defn my-flatten [xs]
  (cond
    (empty? xs) '()
    (seq? (first xs)) (concat (my-flatten (first xs)) (my-flatten (rest xs)))
    :else (cons (first xs) (my-flatten (rest xs)))))

(assert (= '(:a :b :c :d :e)
           (my-flatten '(:a (:b (:c :d) :e)))))
