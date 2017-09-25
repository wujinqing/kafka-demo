package com.jin.kafka.forthexample;

import com.jin.kafka.util.ResourceLoader;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.PrintWriter;
import java.util.Properties;

/**
 * @author wu.jinqing
 * @date 2017年09月25日
 */
public class HikariTest {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig(ResourceLoader.loadProperties("hikari.properties"));
        HikariDataSource ds = new HikariDataSource(config);

        ds.getConnection()
    }
}
