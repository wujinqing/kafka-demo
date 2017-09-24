package com.jin.kafka.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware {
    private static final Logger logger = LogManager.getLogger(AppContext.class);

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        applicationContext = context;
        showBeanNames();
    }

    public static <T> T getBean(Class<T> clazz)
    {
        return applicationContext.getBean(clazz);
    }

    public static String showBeanNames()
    {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for(String bean : applicationContext.getBeanDefinitionNames())
        {
            if(0 != i++)
                sb.append(", ");

            sb.append(bean);
        }

        logger.info("beans: [{}]", sb.toString());

        return sb.toString();
    }

}
