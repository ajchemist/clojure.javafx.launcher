(ns clojure.javafx.launcher-test
  (:require
   [clojure.test :as test :refer [deftest is are testing]]
   [clojure.javafx.launcher :refer :all]
   )
  (:import
   javafx.application.Platform
   ))

(defn test-all
  []
  (Platform/exit))
