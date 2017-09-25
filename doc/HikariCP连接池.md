## HikariCP连接池

### 配置信息说明
> HikariCP uses milliseconds for all time values.

### dataSourceClassName 驱动类
> 示例: dataSourceClassName=com.mysql.jdbc.Driver

### jdbcUrl 连接URL
> 示例: jdbcUrl=jdbc:mysql://localhost:3306/kafka?characterEncoding=utf8

### username 数据库用户名
> 示例: username=root

### password 数据库密码
> 示例: password=root

### autoCommit 是否自动提交，默认: true
> 示例: autoCommit=true

### connectionTimeout 获取连接超时时间
> 从连接池当中获取连接的最大等待时间，等待超过这个还没获取到可用连接将抛出SQLException异常。

> 最小值: 250 ms. 默认: 30000ms (30 seconds)


### idleTimeout 空闲时间
> 空闲的连接待在连接池里面的最大时间，如果超过这个时间连接还处于空闲状态, 连接将会被关闭。

> 只有当**minimumIdle**小于**maximumPoolSize**时这个设置才会生效。

> 当该值为0是，表示连接永远不会超时，一直待在连接池里面，最小值是 10000ms (10 seconds).
> 默认值是600000ms (10 minutes).

### maxLifetime 连接在池里面的最大存活时间
> **强烈推荐**设置该选项，设置连接在池里面的最大存活时间，正在使用的连接永远不会被回收。

> 如果一个连接已经到达maxLifetime，如果这个连接处于空闲状态将直接被回收，
如果这个连接处于正在使用状态，当本次操作使用完连接将被删除。

> 至少设置为30分钟。

> 该值为0时，连接将永久存活。

> 默认值是: 1800000ms (30 minutes)

> VS **idleTimeout**, idleTimeout表示连接闲置的这个时间将会被回收，
> maxLifetime表示连接在池里面存活了这个时间后将会被回收。

### minimumIdle 最小的空闲连接数
> 连接池里面维护的最小连接个数, 为了获得最大的性能和响应能力，推荐不设置这个属性。
> 默认值是：**maximumPoolSize**

### maximumPoolSize 最大连接数
> 连接池里面允许存放的连接的最大数量(含空闲的及正在使用的)。

> 当连接到达最大数量，且没有空闲的连接可以使用时，后续的获取连接操作将阻塞等待**connectionTimeout**
毫秒的时间，直至超时，默认最大连接数的10。

### poolName 设置连接池名字
> 设置连接池名字, 用于在日志、JMX里面唯一标识连接池。