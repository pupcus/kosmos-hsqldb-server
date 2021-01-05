(defproject kosmos/kosmos-hsqldb-server "0.0.7-SNAPSHOT"

  :description "hsqldb server component"

  :url "https://github.com/pupcus/kosmos-hsqldb-server"

  :scm {:url "git@github.com:pupcus/kosmos-hsqldb-server.git"}

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :signing {:gpg-key "FCA46A30FEEE7E10"}

  :dependencies [[kosmos "0.0.12"]
                 [org.clojure/tools.logging "1.1.0"]
                 [org.hsqldb/hsqldb "2.5.1"]]

  :profiles {:dev {:resource-paths ["dev-resources"]
                   :dependencies   [[org.clojure/clojure "1.10.1"]
                                    [org.clojure/java.jdbc "0.7.11"]
                                    [org.slf4j/slf4j-log4j12 "1.7.30"]]}}

  :deploy-repositories {"releases" {:url "https://clojars.org/repo" :creds :gpg :sign-releases false}
                        "snapshots" {:url "https://clojars.org/repo" :creds :gpg :sign-releases false}}

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]

  :global-vars {*warn-on-reflection* true
                *assert* false})
