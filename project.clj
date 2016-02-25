(defproject kosmos/kosmos-hsqldb-server "0.0.2-SNAPSHOT"

  :description "hsqldb server component"

  :url "https://bitbucket.org/pupcus/kosmos-hsqldb-server"

  :scm {:url "git@bitbucket.org:bitbucket/kosmos-hsqldb-server"}

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[kosmos "0.0.3"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.hsqldb/hsqldb "2.3.3"]]

  :profiles {:dev {:resource-paths ["dev-resources"]
                   :dependencies   [[org.clojure/clojure "1.8.0"]
                                    [org.clojure/java.jdbc "0.4.2"]
                                    [org.slf4j/slf4j-log4j12 "1.7.5"]]}}

  :deploy-repositories [["snapshots"
                         {:url "https://clojars.org/repo"
                          :creds :gpg}]
                        ["releases"
                         {:url "https://clojars.org/repo"
                          :creds :gpg}]]

  :global-vars {*warn-on-reflection* true
                *assert* false})
