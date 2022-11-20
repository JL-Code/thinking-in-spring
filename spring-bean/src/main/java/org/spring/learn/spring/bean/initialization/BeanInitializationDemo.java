package org.spring.learn.spring.bean.initialization;

import org.spring.learn.ioc.overview.domain.User;
import org.spring.learn.spring.bean.factory.DefaultUserFactory;
import org.spring.learn.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Bean 初始化示例
 * {@link PostConstruct}
 * {@link Bean#initMethod()}
 * {@link InitializingBean#afterPropertiesSet()}
 * <p>创建时间: 2022/11/19 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class BeanInitializationDemo {

    public static void main(String[] args) {
        // 1. 创建一个 BeanFactory
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 2. 注册 AnnotationBeanDefinitionDemo 作为 Configuration Class
        context.register(BeanInitializationDemo.class);
        context.refresh();
        // 非延迟初始化在 Spring 容器启动时初始化
        System.out.println("Spring 应用上下文已启动...");
        UserFactory bean = context.getBean(UserFactory.class);
        System.out.println(bean.createInstance());

        lookupCollectionByType(context, UserFactory.class);

        System.out.println("准备关闭应用上下文...");
        context.close();
        System.out.println("已关闭应用上下文...");
    }

    private static void lookupCollectionByType(BeanFactory beanFactory, Class<?> classz) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map beansOfType = listableBeanFactory.getBeansOfType(classz);
        System.out.println("lookup collection users :\n" + beansOfType);
    }


    @Bean(initMethod = "innerInit",destroyMethod = "innerDestroy")
    @Lazy(value = false)
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
