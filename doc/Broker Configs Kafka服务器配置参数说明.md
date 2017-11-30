## Broker配置参数说明

### Broker Configs

|参数|说明|示例|
|---|---|---|
|broker.id|每一个broker在集群中的唯一标识|broker.id =0|
|log.dirs|kafka存放数据的路径|log.dirs=/tmp/kafka-logs|
|zookeeper.connect|指定zk连接|127.0.0.1:3000,127.0.0.1:3001,127.0.0.1:3002|
|log.cleanup.policy|数据清理策略, 当数据失效时如何处理,delete：删除(默认值), compact: 压缩|log.cleanup.policy=delete|
|log.retention.hours|数据保存时间, 单位：小时, 当数据在服务器中保存时间超过这个值时将根据清理策略进行处理|log.retention.hours=168|
|log.retention.minutes|数据保存时间, 单位：分钟, 当数据在服务器中保存时间超过这个值时将根据清理策略进行处理|log.retention.minutes=10080|
|log.retention.ms|数据保存时间, 单位：毫秒, 当数据在服务器中保存时间超过这个值时将根据清理策略进行处理|log.retention.minutes=604800000|
|log.retention.bytes|每个topic下每个partition保存数据的总量；注意，这是每个partitions的上限，因此这个数值乘以partitions的个数就是每个topic保存的数据总量。同时注意：如果log.retention.hours和log.retention.bytes都设置了，则超过了任何一个限制都会造成删除一个段文件。注意，这项设置可以由每个topic设置时进行覆盖。|log.retention.bytes=1073741824|
|log.segment.bytes|一个topic可以有多个partition，每个partition的数据会存放在多个segment中，设置每个segment的大小，当某个segment存放的数据超过这个大小时将创建新的segment。|log.segment.bytes=1073741824|
|log.retention.check.interval.ms|定时检查的时间间隔，单位：毫秒；定时检查segments里面的数据是否失效|log.retention.check.interval.ms=300000|
|zookeeper.connection.timeout.ms|与zk建立连接的超时时间，毫秒，没有设置将使用zookeeper.session.timeout.ms的值|zookeeper.connection.timeout.ms=6000|
|zookeeper.session.timeout.ms|Zookeeper session timeout，默认值6000|zookeeper.session.timeout.ms=6000|
|num.network.threads|服务器(Broker)用于在网络上接受和发送数据的线程数|num.network.threads=3|
|num.io.threads|服务器(Broker)用于处理请求可能包括磁盘I/O的线程数|num.io.threads=8|
|socket.send.buffer.bytes|socket的发送缓冲区，socket的调优参数SO_SNDBUFF|socket.send.buffer.bytes=102400|
|socket.receive.buffer.bytes|socket的接受缓冲区，socket的调优参数SO_RCVBUFF|socket.receive.buffer.bytes=102400|
|socket.request.max.bytes|socket请求的最大数值，防止serverOOM，message.max.bytes必然要小于socket.request.max.bytes，会被topic创建时的指定参数覆盖|socket.request.max.bytes=104857600|
|num.partitions|每个topic的默认partitions数量，会被topic创建时的指定参数覆盖|num.partitions=1|


