(defn encrypt [input n]
  (def output "")
  (def skip (- (* n 2) 2))
  (dotimes [row n] ; loop through rows
    (dotimes [column (count input)] ; loop through columns
      (when (or (= 0 (mod (+ row column) skip)) (= 0 (mod (- column row) skip)))
        (def output (str output (nth input column)))))) ; add word to ouput
  apply str (clojure.string/replace output " " "_")) ; replacing space

(defn decrypt [input n]
  (def output (clojure.string/replace input " " "_")) ; replacing space
  (def row 0)
  (def direction false)
  (clojure.string/join
   (for [[pos res]
    (sort-by first
      (for [[i char] (zipmap ;looping through made mapping
        (sort (vec
          (for [column (range 0 (count output))] (do
            (if (or (= 0 row) (= row (- n 1)))
            (def direction (not direction)))
            (def index (+ (* row (count output)) column)) ;caculating index
            (def row
            (if (true? direction) ;choosing to increment or decrement row value
              (inc row)
              (dec row)))
            index))))
          (vec output))] ; making vector
            [(mod i (count output)) char]))] res)))

(encrypt "Funkcionala programmesana" 3)
(decrypt "Fcapreaukinl rgamsnnoaoma" 3)
