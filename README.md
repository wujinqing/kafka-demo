## Kafka学习笔记


### 启动服务
官网下载
> http://kafka.apache.org/downloads

解压
> tar -xzf kafka_2.11-1.0.0.tgz

进入kafka安装目录
> cd kafka_2.11-1.0.0

启动ZooKeeper服务器
> ./bin/zookeeper-server-start.sh ./config/zookeeper.properties

启动kafka服务器
> ./bin/kafka-server-start.sh ./config/server.properties


[Producer配置](doc/Producer配置.md)

[Kafka文件存储机制](https://tech.meituan.com/kafka-fs-design-theory.html)



























































