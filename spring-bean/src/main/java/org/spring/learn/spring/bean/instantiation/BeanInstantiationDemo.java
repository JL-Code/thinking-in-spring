package org.spring.learn.spring.bean.instantiation;

import org.spring.learn.ioc.overview.domain.User;
import org.spring.learn.spring.bean.factory.UserFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Bean Instantiation 示例 {@link }
 * <p>创建时间: 2022/11/19 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        // 1. 创建一个 BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 2. 添加 XML Bean 定义到 BeanFactory
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("META-INF/bean-instantiation-context.xml");
        // Java API 静态工厂实例化 Bean
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanDefinition.setFactoryMethodName("valueOf");
        defaultListableBeanFactory.registerBeanDefinition("user-static-factory-method-java-api", beanDefinition);

        /**
         * XML 静态工厂方法实例化示例
         * <bean id="user-static-factory-method" class="org.spring.learn.ioc.overview.domain.User"
         * factory-method="valueOf"/>
         */
        User user1 = defaultListableBeanFactory.getBean("user-static-factory-method", User.class);
        User user2 = defaultListableBeanFactory.getBean("user-static-factory-method-java-api", User.class);
        User user3 = defaultListableBeanFactory.getBean("user-instance-factory-method", User.class);
        User userFactoryBean = defaultListableBeanFactory.getBean("userFactoryBean", User.class);

        UserFactoryBean bean = defaultListableBeanFactory.getBean(UserFactoryBean.class);
        System.out.println(bean);

        System.out.println("user-static-factory-method bean: " + user1);
        System.out.println("user-static-factory-method-java-api bean: " + user2);
        System.out.println("user-instance-factory-method-java-api bean: " + user3);
        System.out.println("userFactoryBean bean: " + userFactoryBean);

    }
}
