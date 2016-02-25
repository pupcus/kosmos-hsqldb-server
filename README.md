# kosmos-hsqldb-server

hsqldb server component for kosmos (used for testing purposes)

## Usage

Add something like this to your kosmos config:

```
    :server
    {
      :kosmos/init :kosmos.server/HsqlDbServerComponent
      :port        "9005"
      :database    "file:target/db/test"
      :dbname      "test"
    }
```

then connect with jdbc using one of its database specs

example:

```
    {
      :classname       "org.hsqldb.jdbc.JDBCDriver"
      :subprotocol     "hsqldb"
      :protocol        "hsql"
      :host            "localhost"
      :port            9005
      :database        "test"
      :user            "SA"
      :password        ""
     }
```

## License

Kosmos is distributed under the [Eclipse Public License](http://opensource.org/licenses/eclipse-1.0.php), the same as Clojure.
