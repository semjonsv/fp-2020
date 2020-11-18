;; 1. Find the last element of a list.
(defn my-last [xs]
  (last xs))

(assert (= :d
           (my-last '(:a :b :c :d))))

;; 2. Find the N-th element of a list.
(defn get-nth [xs n]
  (nth xs n))

(assert (= :c
           (get-nth '(:a :b :c :d) 2)))

;; 3. Find the length of a list
(defn my-length [xs]
  (count xs))

(assert (= 4
           (my-length '(:a :b :c :d))))

;; 4. Reverse a list.
(defn my-reverse [xs]
  (reverse xs))

(assert (= '(:d :c :b :a)
           (my-reverse '(:a :b :c :d))))

;; 5. Find out whether a list is a palindrome.
(defn is-palindrome? [xs]
  (= (seq xs) (reverse xs)))

(assert (= true
           (is-palindrome? '(:a :b :c :b :a))))

;; 6. Duplicate the elements of a list.
(defn duplicate [xs]
  nil)

(assert (= '(:a :a :b :b :c :c)
           (duplicate '(:a :b :c))))

;; 7. Eliminate consecutive duplicates of a list.
(defn compress [xs]
  (dedupe xs))

(assert (= '(:a :b :c)
           (compress '(:a :a :b :b :c :c))))

;; 8. Remove the N-th element of a list
(defn remove-at [xs n]
  (keep-indexed #(if (not= %1 n) %2) xs))

(assert (= '(:a :b :d :e)
           (remove-at '(:a :b :c :d :e) 2)))

;; 9. Insert a new element at the N-th position of a list.
(defn insert-at [x xs n]
  (if (= 0 n)(cons x xs)
  (cons (first xs) (insert-at x (next xs) (dec n))))
)

(assert (= '(:a :b :x :c :d)
           (insert-at :x '(:a :b :c :d) 2)))

;; 10. Create a list containing all integers within a given range.
(defn my-range [a b]
  (range a (+ b 1)))

(assert (= '(3 4 5 6 7)
           (my-range 3 7)))

;; 11. Concatenate two lists
(defn my-concat [xs ys]
  (concat xs ys))

(assert (= '(:a :b :c :d :e :f)
           (my-concat '(:a :b :c) '(:d :e :f))))

;; 12. Split a list into two parts; the length of the first part is given.
(defn my-drop [xs n]
  ((split-at n xs)1))

(assert (= '(:d :e)
           (my-drop '(:a :b :c :d :e) 3)))

;; 13. Split a list into two parts; the length of the first part is given.
(defn my-take [xs n]
  ((split-at n xs)0))

(assert (= '(:a :b :c)
           (my-take '(:a :b :c :d :e) 3)))

;; 14. Implement the filtering function
(defn my-filter [p xs]
  (keep-indexed #(if (p %2) %2) xs))

(assert (= '(1 3 5)
           (my-filter odd? '(1 2 3 4 5))))

;; 15. Implement the mapping function
(defn my-map [f xs]
 (loop [f f xs xs acc []]
   (if (empty? xs)
     acc
     (recur f (rest xs) (conj acc (f (first xs)))))))

(assert (= '(2 3 4 5 6)
           (my-map inc '(1 2 3 4 5))))

;; 16. Implement the reducing function
(defn my-reduce [f acc xs]
  (reduce f acc xs))

(assert (= 15
           (my-reduce + 0 '(1 2 3 4 5))))

;; 17. Implement the flattening function
(defn my-flatten [xs]
  (flatten xs))

(assert (= '(:a :b :c :d :e)
           (my-flatten '(:a (:b (:c :d) :e)))))
