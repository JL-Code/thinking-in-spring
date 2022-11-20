package org.spring.learn.ioc.overview.dependency.injection;

import org.spring.learn.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过名称：依赖查找示例
 * <p>创建时间: 2022/11/17 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) throws Exception {
        // 1. 配置 XML 配置文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        // 2. 启动 Spring 应用上下文
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println("by id userRepository users bean : " + userRepository.getUsers());
        System.out.println("getBeanFactory: " + userRepository.getBeanFactory());
        // UserRepository 依赖注入的 BeanFactory 与当前 beanFactory 不相同？
        System.out.printf("userRepository.getBeanFactory() == beanFactory: %s", userRepository.getBeanFactory() == beanFactory);
        // throw NoSuchBeanDefinitionException,.
//        System.out.println("beanFactory 无法通过 beanFactory.getBean 查找出来：" + beanFactory.getBean(BeanFactory.class));
        System.out.println(userRepository.getObjectFactory().getObject());
        // 延迟依赖注入
        System.out.println(userRepository.getUserObjectFactory().getObject());
    }
}