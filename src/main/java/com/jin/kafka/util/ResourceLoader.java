package com.jin.kafka.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 资源加载器类
 */
public class ResourceLoader {
    public static Properties loadProperties(String fileName)
    {
        Properties p = new Properties();

        try {
            p.load(ResourceLoader.class.getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return p;
    }
}
