package com.jin.kafka.fifthexample;

import com.jin.kafka.util.ResourceLoader;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Log4jdbcTest {
    private static HikariDataSource dataSource;

    static
    {
        HikariConfig config = new HikariConfig(ResourceLoader.loadProperties("log4jdbc.properties"));
        dataSource = new HikariDataSource(config);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("开始");
        Connection connection = dataSource.getConnection();

        connection.setAutoCommit(false);

        String sql = "INSERT INTO student (name, age, address) VALUES (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, "zhangsan");
        ps.setInt(2, 20);
        ps.setString(3, "shanghai");

        ps.execute();

        connection.commit();

        System.out.println("结束。");
    }
}
