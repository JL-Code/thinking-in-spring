package org.spring.learn.spring.bean.definition;

import org.spring.learn.spring.bean.factory.DefaultUserFactory;
import org.spring.learn.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 外部单例对象注册示例：
 * {@link SingletonBeanRegistry}
 * {@link ConfigurableListableBeanFactory}
 * {@link DefaultListableBeanFactory}
 * <p>创建时间: 2022/12/1 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {
        // 1. 创建一个 ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 使用 SingletonBeanRegistry 接口实现类注册一个外部单例对象到工厂
        UserFactory externalSingletonBean = new DefaultUserFactory();
        beanFactory.registerSingleton("userFactory", externalSingletonBean);

        // 依赖查找 UserFactory
        UserFactory beanByLookup = beanFactory.getBean(UserFactory.class);

        // 比较外部对象与在容器内通过依赖查找的 Bean 是否一致
        System.out.println("externalSingletonBean == beanByLookup: " + (externalSingletonBean == beanByLookup));

    }
}
