package com.jin.kafka.thirdexample;

import com.alibaba.fastjson.JSON;
import com.jin.kafka.db.entity.Student;
import com.jin.kafka.db.service.StudentService;
import com.jin.kafka.util.AppContext;
import com.jin.kafka.util.ResourceLoader;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class ConsumerTest3 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService studentService = AppContext.getBean(StudentService.class);

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(ResourceLoader.loadProperties("kafka-consumer.properties"));

        kafkaConsumer.subscribe(Arrays.asList("MyTopic_03"));

        while (true)
        {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(3000);

            if(!records.isEmpty())
            {
                records.forEach(r -> {
                    Student student = JSON.parseObject(r.value(), Student.class);

                    System.out.println("name:" + student.getName());
                    System.out.println("age:" + student.getAge());
                    System.out.println("address:" + student.getAddress());

                    studentService.save(student);
                });
            }
        }
    }
}
