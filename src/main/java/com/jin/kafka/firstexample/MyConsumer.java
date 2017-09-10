package com.jin.kafka.firstexample;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

/**
 * @author wu.jinqing
 * @date 2017年09月05日
 */
public class MyConsumer {
    public static void main(String[] args) {
//        Properties props = new Properties();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.20.33.234:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "MyConsumer");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
//        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//
//        String topic = "test";
//        KafkaConsumer<Integer, String> consumer = new KafkaConsumer<>(props);
//
//        consumer.subscribe(Collections.singletonList(topic));
//
//        ConsumerRecords<Integer, String> records = consumer.poll(1000);
//
//        for (ConsumerRecord<Integer, String> record : records) {
//            System.out.println("收到消息, record: " + JSON.toJSONString(record));
//        }


        Properties props = new Properties();
        props.put("bootstrap.servers", "172.20.33.234:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("foo", "bar", "my-topic"));
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("收到数据, offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }
}
