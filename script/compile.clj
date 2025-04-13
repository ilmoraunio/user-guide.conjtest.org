#!/usr/bin/env bb

(require '[babashka.process :as p])

(def out-page "gh-pages/index.html")
(-> (p/$ asciidoctor src/book.adoc -o ~out-page -a docinfo=shared)
    (p/check))

(binding [*out* *err*]
  (println "Done writing to" out-page))
