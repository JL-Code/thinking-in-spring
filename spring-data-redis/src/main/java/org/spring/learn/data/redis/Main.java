package org.spring.learn.data.redis;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TODO
 * <p>创建时间: $DATE </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class Main {

    private static RedisTemplate<String, String> redisTemplate;

    public Main(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public static void main(String[] args) {
        initIoC();
        RedisTest redisTest = new RedisTest();
        redisTest.run(redisTemplate);
        redisTest.batchWrite(redisTemplate);
    }

    public static void initIoC() {
        // 1. 创建一个 BeanFactory (注解式)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 2. 注册当前类作为 Configuration Class
        context.register(Main.class);
        context.registerBean(RedisConfig.class);
        // 3. 启动容器
        context.refresh();

//        lookupCollectionByType(context, RedisConnectionFactory.class);
//        lookupCollectionByType(context, RedisTemplate.class);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory, Class<?> classz) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map beansOfType = listableBeanFactory.getBeansOfType(classz);
        System.out.println("lookup collection :\n" + beansOfType);
    }
}