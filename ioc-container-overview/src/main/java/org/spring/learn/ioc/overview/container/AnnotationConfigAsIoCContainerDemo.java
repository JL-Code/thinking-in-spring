package org.spring.learn.ioc.overview.container;

import org.spring.learn.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.Map;

/**
 * ApplicationContext 作为 IoC容器的示例 {@link ApplicationContext}
 * <p>创建时间: 2022/11/18 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@Import(UserBeanPostProcesser.class)
public class AnnotationConfigAsIoCContainerDemo {

    public static void main(String[] args) throws Exception {
        // 1. 创建一个 ApplicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 2. 通过注解将 Bean 加入到容器
        applicationContext.register(AnnotationConfigAsIoCContainerDemo.class);
        // 3. 刷新 Spring 应用上下文
        applicationContext.refresh();
        // 4. 通过依赖查找获取 Bean
        lookupCollectionByType(applicationContext);

        UserFactoryBean userFactoryBean = applicationContext.getBean(UserFactoryBean.class);
        User user = userFactoryBean.getObject();
        System.out.println("userFactoryBean user: " + user);
        System.out.println(userFactoryBean.getObject() == userFactoryBean.getObject());
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(33L);
        user.setName("相貌平平");
        return user;
    }

    @Bean
    public UserFactoryBean userFactoryBean() {
        return new UserFactoryBean();
    }


    private static void lookupCollectionByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
        System.out.println("applicationContext as ioc container lookup collection users :\n" + beansOfType);
    }

}
