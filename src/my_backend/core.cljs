(ns my-backend.core
  (:require [misc.core :refer [=>]]
            ["express" :as express]))

(defonce app (express))
(defonce svr-ref (volatile! nil))

(def person (js-obj "name" "Alex"
                    "age" 18))

(defn say-hello
  [req res]
  (let [msg (str "Hello " (=> person "name"))]
    (.send res msg)))

(defn main [& args]
  (.get app "/" say-hello)
  (let [port 3000]
    (->> (partial println (str "Running at localhost:" port))
         (.listen app port)
         (vreset! svr-ref))))

(defn start [] (main))

(defn stop [done]
  (when-some [svr @svr-ref]
    (.close svr done)))
