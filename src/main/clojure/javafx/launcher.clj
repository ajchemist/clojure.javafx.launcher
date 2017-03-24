(ns clojure.javafx.launcher
  (:require
   [clojure.javafx.application :as app]
   )
  (:import
   javafx.application.Application
   javafx.application.Platform
   [clojure.javafx.application.Application]
   ))

(defonce launcher-thread
  (delay
   (doto (Thread.
          (fn []
            ;; Keep JavaFX running even if no window is visible
            (Platform/setImplicitExit false)
            (Application/launch clojure.javafx.application.Application (into-array String []))))
     (.start))))

(defn- launch!
  "Application launch must not be called more than once"
  []
  @launcher-thread
  @app/primary-stage
  nil)

;;;

(launch!)
