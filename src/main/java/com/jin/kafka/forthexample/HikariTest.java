package com.jin.kafka.forthexample;

import com.jin.kafka.util.ResourceLoader;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * @author wu.jinqing
 * @date 2017年09月25日
 */
public class HikariTest {
    private static final int BATCH_SIZE = 10000;
    public static final String LONG_TEXT = "空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。空杯子才可以装下更多的东西。首先要学会取百家之长，带着欣赏的眼光看团队的同事或学校的同学，欣赏每位同事或同学的优点，然后吸取他们的优点，每个同事都有其擅长的能力，比如有的同事技术能力强，那么可以观察下他如何学习的（或者找他请教学习方法），有的同学擅长解决线上问题，那么观察他是如何解决线上问题的，解决思路是什么？如果他解决不了时，他是如何寻求帮助。有的同学擅长使用IDE或MAC的快捷键，那么可以向他学习提高工作效率。";
    public static final String LONG_TEXT1 = "吴晋清123";

    private static HikariDataSource ds;

    static
    {
        HikariConfig config = new HikariConfig(ResourceLoader.loadProperties("hikari.properties"));
        ds = new HikariDataSource(config);
    }

    public static void main(String[] args) throws SQLException {
//        singleInsert();
        batchInsert();


    }

    private static void multiThreadBatchInsert() throws SQLException {
        CountDownLatch latch = new CountDownLatch(1);

        for(int t = 0; t < 20; t++)
        {
            new Thread(() -> {
                try {
                    latch.await();
                    batchInsert();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        latch.countDown();
    }
    private static void batchInsert() throws SQLException {
        long st = System.currentTimeMillis();

        Connection connection = ds.getConnection();

        connection.setAutoCommit(false);

        String sql = "INSERT INTO student (name, age, address) VALUES  (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        for(int i = 0; i < BATCH_SIZE; i++) {
            ps.clearParameters();
            ps.setString(1, "zhangsan-" + i);
            ps.setInt(2, i);
            ps.setString(3, "shanghai-" + i + LONG_TEXT);
            ps.addBatch();
        }

        ps.executeBatch();
        connection.commit();
        long ed = System.currentTimeMillis();

        System.out.println("batchInsert结束, 耗时：【" + (ed - st) + "】毫秒！");
    }
    private static void singleInsert() throws SQLException {
        long st = System.currentTimeMillis();

        Connection connection = ds.getConnection();

        String sql = "INSERT INTO student (name, age, address) VALUES  (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        for(int i = 0; i < BATCH_SIZE; i++) {
            ps.clearParameters();
            ps.setString(1, "zhangsan-" + i);
            ps.setInt(2, i);
            ps.setString(3, "shanghai-" + i);

            ps.execute();
        }


        long ed = System.currentTimeMillis();

        System.out.println("singleInsert结束, 耗时：【" + (ed - st) + "】毫秒！");
    }
}
