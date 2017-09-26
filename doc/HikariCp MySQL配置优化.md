## MySQL配置优化


### [原文地址](https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration)


### prepStmtCacheSize

> the number of prepared statements that the MySQL driver will cache per connection.

> 默认值是25, 推荐设置为: 250 - 500之间。

### prepStmtCacheSqlLimit
> This is the maximum length of a prepared SQL statement that the driver will cache.

> 默认值是256, 推荐设置为: 2048。

### cachePrepStmts 是否开启缓存
> 必须设置为true. 否则**prepStmtCacheSize**及**prepStmtCacheSqlLimit**两项设置将不起作用。



### useServerPrepStmts 启动服务器端缓存SQL

> Newer versions of MySQL support server-side prepared statements,
this can provide a substantial performance boost. Set this property to true.


### 一个典型的MySQL配置：

> jdbcUrl=jdbc:mysql://localhost:3306/simpsons

> user=test

> password=test

> dataSource.cachePrepStmts=true

> dataSource.prepStmtCacheSize=250

> dataSource.prepStmtCacheSqlLimit=2048

> dataSource.useServerPrepStmts=true

> dataSource.useLocalSessionState=true

> dataSource.useLocalTransactionState=true

> dataSource.rewriteBatchedStatements=true

> dataSource.cacheResultSetMetadata=true

> dataSource.cacheServerConfiguration=true

> dataSource.elideSetAutoCommits=true

> dataSource.maintainTimeStats=false








