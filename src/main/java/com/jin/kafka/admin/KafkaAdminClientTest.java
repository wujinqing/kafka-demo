package com.jin.kafka.admin;

import com.jin.kafka.util.ResourceLoader;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaAdminClientTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("start");
        AdminClient adminClient = AdminClient.create(ResourceLoader.loadProperties("kafka-admin.properties"));

        ListTopicsResult topics = adminClient.listTopics();

        topics.names().get().forEach(System.out::println);

        System.out.println("end");
    }
}
