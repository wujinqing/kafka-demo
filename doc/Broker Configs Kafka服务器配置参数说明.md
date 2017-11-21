## Broker配置参数说明

### Broker Configs

|---|---|
|名称|IP|
|TMS|172.28.33.80|


|---|---|---|---|---|---|
|参数|说明|类型|默认值|有效值|重要级别|
|broker.id|每一个broker在集群中的唯一表示，要求是正数。当该服务器的IP地址发生改变时，broker.id没有变化，则不会影响consumers的消息情况|string|null|无|high|
|log.dirs||||||
|zookeeper.connect||||||