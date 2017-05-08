(def +version+ "0.1.0")

(set-env!
 :source-paths #{"src/main" "src/test"}
 :dependencies
 '[
   [org.clojure/clojure "1.8.0" :scope "provided"]

   #_[adzerk/boot-test "1.2.0" :scope "test"]
   [adzerk/bootlaces "0.1.13" :scope "test"]
   ])

(require
 '[boot.clojure.javafx :refer [launch-javafx]]
 '[adzerk.bootlaces :refer :all])

(task-options!
 pom
 {:project 'clojure.javafx.launcher
  :url "https://github.com/aJchemist/clojure.javafx.launcher"
  :scm {:url "https://github.com/aJchemist/clojure.javafx.launcher"}
  :license {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}
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
