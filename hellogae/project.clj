(defproject hello-gae "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :aot [hellogae.core]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring/ring-servlet "1.1.0"]
                 [compojure "1.0.4"]]
  :plugins [[lein-swank "1.4.4"]]
  :compile-path "war/WEB-INF/classes"
  :library-path "war/WEB-INF/lib")