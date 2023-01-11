package org.spring.learn.data.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * TODO
 * <p>创建时间: 2023/1/8 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class RedisConfig {
    @Bean
    public LettuceConnectionFactory redisConnFactoryForStandalone() {
        // Redis 单机版
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("127.0.0.1", 6379));
    }

    /**
     * RedisTemplate 是线程安全的。
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory, RedisSerializer<String> redisSerializer) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setDefaultSerializer(redisSerializer); // 设置 Redis 默认序列化类
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * Redis K,V 序列化 Bean
     *
     * @return
     */
    @Bean
    public RedisSerializer<String> redisSerializer() {
        return new StringRedisSerializer();
    }
}
