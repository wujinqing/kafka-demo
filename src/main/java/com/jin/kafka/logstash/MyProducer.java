package com.jin.kafka.logstash;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author wu.jinqing
 * @date 2017年09月05日
 */
public class MyProducer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {



        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(300);
            AccessLog log = new AccessLog("TM050" + (i % 10 ), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")), "测试消息:" + i);


            producer.send(new ProducerRecord<String, String>("hello_world_topic", JSON.toJSONString(log)), (rm, ex) -> {
                if(ex != null)
                {
                    System.out.println("发送失败。");
                    ex.printStackTrace();
                }else {
                    System.out.println("消息发送成功, offset:" + rm.offset());
                }
            });

        }
        producer.close();
    }
}
