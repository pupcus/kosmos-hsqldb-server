(defproject kosmos/kosmos-hsqldb-server "0.0.4-SNAPSHOT"

  :description "hsqldb server component"

  :url "https://bitbucket.org/pupcus/kosmos-hsqldb-server"

  :scm {:url "git@bitbucket.org:bitbucket/kosmos-hsqldb-server"}

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[kosmos "0.0.10"]
                 [org.clojure/tools.logging "0.5.0"]
                 [org.hsqldb/hsqldb "2.5.0"]]

  :profiles {:dev {:resource-paths ["dev-resources"]
                   :dependencies   [[org.clojure/clojure "1.10.1"]
                                    [org.clojure/java.jdbc "0.7.10"]
                                    [org.slf4j/slf4j-log4j12 "1.7.25"]]}}

  :deploy-repositories {"releases" {:url "https://repo.clojars.org" :creds :gpg :sign-releases false}
                        "snapshots" {:url "https://repo.clojars.org" :creds :gpg :sign-releases false}}

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
