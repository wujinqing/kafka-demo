package com.jin.kafka.thirdexample;

import com.alibaba.fastjson.JSON;
import com.jin.kafka.bean.Student;
import com.jin.kafka.util.ResourceLoader;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProducerTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(ResourceLoader.loadProperties("kafka-producer.properties"));

        Student student = new Student("李四2", 10, "上海市");

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("MyTopic_03", "My_key_03", JSON.toJSONString(student));



        Future<RecordMetadata> future = kafkaProducer.send(record);

        RecordMetadata metadata = future.get();


        System.out.println("offset:" + metadata.offset());
        System.out.println("partition:" + metadata.partition());

        System.out.println("消息发送完成。");


    }
}
