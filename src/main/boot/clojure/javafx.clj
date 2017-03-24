(ns boot.clojure.javafx
  {:boot/export-tasks true}
  (:require
   [boot.core :as boot :refer [deftask with-pre-wrap]]
   ))

(deftask launch-javafx
  []
  (with-pre-wrap fileset
    (require 'clojure.javafx.launcher)
    fileset))
