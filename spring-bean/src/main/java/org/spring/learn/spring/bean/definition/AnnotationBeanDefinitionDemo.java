package org.spring.learn.spring.bean.definition;

import org.spring.learn.ioc.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionDefaults;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 通过注解的方式注册 Spring Bean 示例 {@link @Bean}
 * <p>创建时间: 2022/11/18 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
@Import(AnnotationBeanDefinitionDemo.Config.class) // 3. 通过 @Import 注册 Bean
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        // 1. 创建一个 BeanFactory
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 2. 注册 AnnotationBeanDefinitionDemo 作为 Configuration Class
        context.register(Config.class);

        registerBeanDefinition("user-java-api", context);
        registerBeanDefinition("", context);
        registerBeanDefinition("", context);

        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
        reader.register(User.class);

        // 3. 刷新上下文
        context.refresh();

        Map<String, Config> beansOfType = context.getBeansOfType(Config.class);

        /**
         * Config 类同时被三种方式注册 Bean ，结果 Spring IoC 容器中没有重复注册，说明容器会自动去重。
         */
        System.out.println("@Bean by type(User.class) : " + context.getBeansOfType(User.class));
        System.out.println("@Bean by name user: " + context.getBean("user"));
        System.out.println("@Bean by alias codeme: " + context.getBean("codeme"));
        System.out.println("@Component by type(Config.class) : " + beansOfType);

        // 4. 关闭上下文
        System.out.println("准备关闭应用上下文...");
        context.close();
        System.out.println("已关闭应用上下文...");
    }

    public static void registerBeanDefinition(String beanName, BeanDefinitionRegistry registry) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);

        if (StringUtils.hasText(beanName)) {
            // 构建 beanDefinition
            beanDefinition.getPropertyValues().add("id", 12L)
                    .add("name", "codeme-named");
            registry.registerBeanDefinition(beanName, beanDefinition);

        } else {
            beanDefinition.getPropertyValues().add("id", 13L)
                    .add("name", "codeme-non-named");
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
        }
    }

    /**
     * 2. 通过 @Component 注册 Bean
     */
    @Component
    public static class Config {

        // 1. 通过 @Bean 注册 Bean
        @Bean(name = {"user", "codeme"})
        public User user() {
            User user = new User();
            user.setName("codeme");
            user.setId(11L);
            return user;
        }
    }
}
