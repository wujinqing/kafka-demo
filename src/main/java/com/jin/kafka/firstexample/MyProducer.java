package com.jin.kafka.firstexample;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author wu.jinqing
 * @date 2017年09月05日
 */
public class MyProducer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "172.20.33.234:9092");
//        props.put("client.id", "MyProducer");
//        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);
//        int messageNo = 2;
//        String topic = "MyFirstTopic";
//        String mesage = "MyMessage";
//        producer.send(new ProducerRecord<Integer, String>(topic, messageNo, mesage));
//
//        producer.close();
//
//        System.out.println("发送完成");


        Properties props = new Properties();
        props.put("bootstrap.servers", "172.20.33.234:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), "发送数据: " + Integer.toString(i)));

        producer.close();
    }
}
