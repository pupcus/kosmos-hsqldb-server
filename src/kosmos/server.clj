(ns kosmos.server
  (:require [clojure.tools.logging :as log]
            [com.stuartsierra.component :as component])
  (:import org.hsqldb.Server
           org.hsqldb.server.ServerConfiguration
           org.hsqldb.persist.HsqlProperties
           org.hsqldb.DatabaseManager
           org.hsqldb.Database))

(defrecord HsqlDbServerComponent [port database dbname]
  component/Lifecycle
  (start [component]
    (let [properties (HsqlProperties.
                      (doto (java.util.Properties.)
                        (.put "server.port"       (:port     component))
                        (.put "server.database.0" (:database component))
                        (.put "server.dbname.0"   (:dbname   component))))
          _             (ServerConfiguration/translateDefaultDatabaseProperty properties)
          server (doto (org.hsqldb.Server.)
                   (.setRestartOnShutdown false)
                   (.setNoSystemExit true)
                   (.setProperties properties))]
      (log/info "Starting hsqldb server component ...")
      (.start server)
      (log/info (str "hsqldb server started successfully listening on port " (.getPort server)))
      (assoc component :server server)))

  (stop [component]
    (log/info "Stopping hsqldb server component")
    (when-let [^org.hsqldb.Server server (:server component)]
      (doto server
        (.signalCloseAllServerConnections)
        (.stop))
      (DatabaseManager/closeDatabases Database/CLOSEMODE_NORMAL)
      (log/info "hsqldb server stopped successfully"))))
