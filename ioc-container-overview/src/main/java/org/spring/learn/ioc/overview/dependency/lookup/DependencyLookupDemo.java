package org.spring.learn.ioc.overview.dependency.lookup;

import org.spring.learn.ioc.overview.annotation.Super;
import org.spring.learn.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 通过名称：依赖查找示例
 * <p>创建时间: 2022/11/17 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 1. 配置 XML 配置文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        // 2. 启动 Spring 应用上下文
        User user = (User) beanFactory.getBean("user");
        System.out.println("by id user bean : " + user);
        lookupByAnnotation(beanFactory);
        lookupByType(beanFactory);

        //  按照类型查找集合对象
        lookupCollectionByType(beanFactory);

//        lookupInLazy(beanFactory);

    }

    /**
     * 根据注解查找 Bean {@link ListableBeanFactory#getBeansWithAnnotation}
     *
     * @param beanFactory
     */
    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(Super.class);

            System.out.println("by annotation beansWithAnnotation: " + beansWithAnnotation);
        }
    }

    /**
     * {@link ListableBeanFactory#getBeansOfType } 根据类型查询集合 Bean 对象
     *
     * @param beanFactory
     */
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);

        System.out.println("collection users :" + beansOfType);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("by type user bean: " + user);
    }

    /**
     * 延迟查找 Bean {@link ObjectFactoryCreatingFactoryBean}
     *
     * @param beanFactory Bean 工厂
     */
    public static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("userObjectFactory");
        User user = objectFactory.getObject();
        System.out.println("lazy lookup bean user: " + user);
    }

}