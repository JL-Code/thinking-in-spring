package org.spring.learn.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.support.AbstractApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 默认的 User Factory {@link org.spring.learn.ioc.overview.domain.User}
 * {@link InitializingBean, DisposableBean}
 * <p>创建时间: 2022/11/19 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("1. @PostConstruct 初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("2. InitializingBean#afterPropertiesSet 初始化中...");
    }

    @Override
    public void innerInit() {
        System.out.println("3. @Bean(initMethod) 初始化中...");
    }

    @Override
    public void innerDestroy() {
        System.out.println("3. @Bean(destroy) 销毁中...");
    }

    /**
     * {@link PreDestroy}
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("1. @PreDestroy 准备销毁 Bean 中...");
    }

    /**
     * 单例 Bean 销毁时调用此方法
     * {@link AbstractApplicationContext#destroyBeans()}
     * {@link DefaultSingletonBeanRegistry#destroyBean(String, DisposableBean)}
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("2. DisposableBean#destroy Bean 销毁中...");
    }

    /**
     * 当垃圾收集确定不再有对对象的引用时，由对象上的垃圾收集器调用。
     * 子类重写 finalize方法以释放系统资源或执行其他清理。
     *
     * @throws Throwable
     */
    @Override
    public void finalize() throws Throwable {
        System.out.println("当前对象，正在被 GC 回收...");
    }
}
