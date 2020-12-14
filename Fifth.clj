(defn encrypt [input n]
  (let [counter (* 2 (dec n))
        array (map
               (fn [start]
                 (take-nth counter
                           (drop start (range))))
               (range counter))
        map-through
        (take
         (count input)
         (loop [id (rest array)
                map-through (take-while
                             #(> (count input) %)
                             (first array))]
           (if
            (= 1 (count id))
             (concat map-through (last id))
             (recur
              (rest (drop-last id))
              (concat
               map-through
               (take-while
                #(> (count input) %)
                (interleave (first id) (last id))))))))]
    (def result (clojure.string/replace input #" " "_"))
    (apply str
           (map #(nth result %) map-through))))

(defn decrypt [input n]
  (let [counter (* 2 (dec n))
        array (map
               (fn [start]
                 (take-nth
                  counter
                  (drop start (range))))
               (range counter))
        map-through
        (take
         (count input)
         (loop [id (rest array)
                map-through (take-while
                             #(> (count input) %)
                             (first array))]
           (if
            (= 1 (count id))
             (concat map-through (last id))
             (recur
              (rest (drop-last id))
              (concat
               map-through
               (take-while
                #(> (count input) %)
                (interleave (first id) (last id))))))))
        map-back (->> map-through
                      (map-indexed vector)
                      (sort-by second)
                      (map first))]
    (def result (clojure.string/replace input #" " "_"))
    (apply str
           (map #(nth result %) map-back))))

(encrypt "Funkcionala programmesana" 3)
(decrypt "Fcapreaukinl rgamsnnoaoma" 3)
