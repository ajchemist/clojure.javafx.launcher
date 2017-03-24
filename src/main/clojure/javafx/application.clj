(ns clojure.javafx.application
  "Extended class javafx.application.Application for clojure.javafx"
  (:import
   javafx.application.Application
   javafx.stage.Stage
   )
  (:gen-class
   :name clojure.javafx.application.Application
   :extends javafx.application.Application
   ))

(defonce primary-stage (promise))

(defn -start
  [this ^Stage stage]
  (deliver primary-stage stage)
  (println "clojure.javafx" (str (Thread/currentThread)) "start()"))

(defn -stop
  [this]
  (println "clojure.javafx" (str (Thread/currentThread)) "stop()"))
