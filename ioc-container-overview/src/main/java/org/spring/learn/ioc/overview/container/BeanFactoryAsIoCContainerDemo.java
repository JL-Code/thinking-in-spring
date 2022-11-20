package org.spring.learn.ioc.overview.container;

import org.spring.learn.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * BeanFactory 作为 IoC容器的示例 {@link BeanFactory}
 * <p>创建时间: 2022/11/18 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {
        // 1. 创建一个 BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 2. 添加 XML Bean 定义到 BeanFactory
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        int beanDefinitionsCount = xmlBeanDefinitionReader.loadBeanDefinitions("classpath:META-INF/dependency-lookup-context.xml");
        // 3. 通过依赖查找获取 Bean
        System.out.println("beanDefinitionsCount: " + beanDefinitionsCount);
        lookupCollectionByType(defaultListableBeanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);

        System.out.println("bean factory as ioc container lookup collection users :\n" + beansOfType);
    }

}
