package org.spring.learn.data.redis;

import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

/**
 * TODO
 * <p>创建时间: 2023/1/8 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class RedisTest {

    public void run(RedisTemplate<String, String> redisTemplate) {
        ListOperations<String, String> ops = redisTemplate.opsForList();
        List<String> list = ops.range("list-key", 0, -1);
        if (list.size() == 0) {
            // \xAC\xED\x00\x05t\x00\x08list-key
            // 上面的类似乱码的 key，就是 spring-data-redis 默认的序列化 JdkSerializationRedisSerializer 导致
            ops.leftPushAll("list-key", "1", "33", "44");
        }
        System.out.println(list);
    }

    public void batchWrite(RedisTemplate<String, String> redisTemplate) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        // 利用 15 个线程，每个循环 1w 次写入字符串。
        int count = 10000;
        for (int i = 0; i < 15; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName();
                for (int j = 0; j < count; j++) {
                    String key = String.format("string-key:%s:%d", name, j);
                    System.out.printf("thread name: string-key:%s key: %s \n", name, key);
                    ops.set(key, String.valueOf(j));
                }
            }, String.valueOf(i)).start();
        }
    }
}
