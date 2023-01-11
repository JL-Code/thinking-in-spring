package org.spring.learn.spring.bean.definition;

import org.spring.learn.spring.bean.factory.DefaultUserFactory;
import org.spring.learn.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Spring Bean GC 示例
 * <p>创建时间: 2022/12/1 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        Long ms = 5000L;
        // 1. 创建一个 BeanFactory
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 2. 注册 BeanGarbageCollectionDemo 作为 Configuration Class
        context.register(BeanGarbageCollectionDemo.class);
        context.refresh();
        System.out.println("Spring 应用上下文已启动...");
        UserFactory bean = context.getBean(UserFactory.class);
        System.out.println(bean.createInstance());
        System.out.println("准备关闭应用上下文...");
        context.close();
        System.out.println("已关闭应用上下文...");
        System.out.printf("主线程休眠 %d s 等待 GC 守护线程进行回收工作...", ms / 1000);
        Thread.sleep(ms);
        // 强制系统调用 GC ...
        System.gc();
        // 增加延时，等待 DefaultUserFactory#finalize 被调用。
        Thread.sleep(ms);
    }

    @Bean
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
