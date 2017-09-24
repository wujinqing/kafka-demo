package com.jin.kafka.secondexample;

import com.alibaba.fastjson.JSON;
import com.jin.kafka.secondexample.ProducerTest2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.record.TimestampType;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author wu.jinqing
 * @date 2017年09月12日
 */
public class ConsumerTest2 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "ConsumerTest2Group");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(ProducerTest2.Topic));

        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ConsumerRecords<String, String> records = consumer.poll(100);

            if(null != records && !records.isEmpty())
            for (ConsumerRecord<String, String> record : records)
            {
                String topic = record.topic();
                String key = record.key();
                String value = record.value();
                int serializedValueSize = record.serializedValueSize();
                long offset = record.offset();
                int partition = record.partition();
                int serializedKeySize = record.serializedKeySize();
                long timestamp = record.timestamp();
                TimestampType timestampType = record.timestampType();
                Headers headers = record.headers();

                System.out.println("topic：" + topic);
                System.out.println("key：" + key);
                System.out.println("value：" + value);
                System.out.println("serializedValueSize：" + serializedValueSize);
                System.out.println("offset：" + offset);
                System.out.println("partition：" + partition);
                System.out.println("serializedKeySize：" + serializedKeySize);
                System.out.println("timestamp：" + timestamp);
                System.out.println("timestampType：" + timestampType.name);
                System.out.println("headers：" + headers.toArray().length);

                for(Header h : headers.toArray())
                {
                    String k = h.key();
                    try {
                        String v = new String(h.value(), "UTF-8");

                        System.out.println("headers, k:" + k + ", v: " + v);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                }



            }
        }
    }
}
