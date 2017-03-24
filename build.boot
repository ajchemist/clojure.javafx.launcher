(def +version+ "0.1.0")

(set-env!
 :source-paths #{"src/main" "src/test"}
 :dependencies
 '[
   [org.clojure/clojure "1.8.0" :scope "provided"]

   #_[adzerk/boot-test "1.1.2" :scope "test"]
   [adzerk/bootlaces "0.1.13" :scope "test"]
   ])

(require
 '[boot.clojure.javafx :refer [launch-javafx]]
 '[adzerk.bootlaces :refer :all])

(task-options!
 pom
 {:project 'clojure.javafx.launcher
  :version +version+})

(deftask devfx
  []
  (comp
   (aot :namespace #{'clojure.javafx.application})
   (launch-javafx)))

(deftask run-test
  []
  (comp
   (aot :namespace #{'clojure.javafx.application})
   (with-pre-wrap fileset
     (require 'clojure.javafx.launcher-test)
     ((resolve 'clojure.javafx.launcher-test/test-all))
     fileset)))

(deftask build
  []
  (comp
   (speak)
   (aot :namespace #{'clojure.javafx.application})
   (sift :add-asset #{"src/main"})
   (pom)
   (jar)
   (install)))

;; Local Variables:
;; compile-command: "boot -P run-test build"
;; End:
