package org.spring.learn.spring.bean.definition;

import org.spring.learn.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * BeanDefinition 创建示例 {@link BeanDefinitionBuilder,AbstractBeanDefinition}
 * <p>创建时间: 2022/11/17 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        // 1. BeanDefinitionBuilder 构建 BeanDefinition
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        builder.addPropertyValue("id", 10L);
        builder.addPropertyValue("name", "codme");

        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = builder.getBeanDefinition();

        System.out.println("beanDefinition: " + beanDefinition);

        // 2. 通过 AbstractBeanDefinition 及其派生类

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 20L)
                .add("name", "codeme");
        genericBeanDefinition.setBeanClass(User.class);
        genericBeanDefinition.setPropertyValues(propertyValues);

        System.out.println("genericBeanDefinition: " + genericBeanDefinition);

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition(genericBeanDefinition.getBeanClassName(), genericBeanDefinition);

        lookupCollectionByType(defaultListableBeanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);

        System.out.println("generic bean definition lookup collection users :\n" + beansOfType);
    }

}
