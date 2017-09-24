## Producer配置

> 所有配置项都包含在此类中: ProducerConfig

### bootstrap.servers

> 设置Broker服务器地址列表, 格式：host1:port1,host2:port2,...

### acks

> 在请求被认为完成之前，Producer需要服务器接收到消息。

> 当acks=all时，服务器能保证至少一次(at least one)收到消息，消息具有最强的可靠性保证，能保证不会丢失。

> 当acks=0时，不能保证服务器能收到消息， 将消息放入缓存就立刻返回，不会等待服务器的ack消息，并告知Producer请求完成。此时retries设置将无效, 返回的消息的offset总是-1。

> 当acks=1时，保证leader服务器能收到消息，不能保证followers服务器收到消息；在leader服务器返回Producer成功之后，且在followers备份之前leader失败了就可能出现数据丢失的情况

### max.in.flight.requests.per.connection

> 单次请求打包发送多条消息的最大消息数量，当发送失败时，由于retries的设置可能导致消息重排序，
当两个打包的请求(batchs) 发送到同一个分区，当第一个batch失败，第二个batch成功，
由于设置了重试会导致服务器优先收到了第二个batch，导致顺序变了。对于对消息有顺序要求的要慎用

### retries

> 但设置为大于零的值时，在消息发送出错时将导致客户端重试。

### batch.size

> 单位：字节bytes, 将多个消息捆绑到一个请求中发送给服务器端的同一个分区(partition)中。

> 此设置既能提高服务器的性能也能提高客户端的性能。

> 批量发送的信息将不会超过该值指定的大小.

> 每个请求可以包含多个batch信息，多个batch可以发送到不同的分区。

> 值设置的太小了会降低吞吐量(如果设置为0将完全禁用batching)，值设置的过大会浪费内存.


### linger.ms

> 设置延迟发送时间，值为0时不延迟，单位：毫秒。在指定的时间内尽量聚合多条信息然后
在一个请求里面将它们一起发送给服务器端.

> 此设置可以降低系统负载.

> 此设置一般需要信息产生的速度比发送到服务器的速度快

> 当聚集的信息大小到达batch.size时将会忽略该设置， 当linger.ms时间到了，
但batch.size没达到，以linger.ms的设置为准.

### buffer.memory

> 用于存放等待发送到服务器端的消息缓存的总的缓存大小

### client.id

> 用于追踪消息的来源

### key.serializer

> key值的序列化器, 如:org.apache.kafka.common.serialization.StringSerializer

### value.serializer

> value值的序列化器, 如:org.apache.kafka.common.serialization.StringSerializer
