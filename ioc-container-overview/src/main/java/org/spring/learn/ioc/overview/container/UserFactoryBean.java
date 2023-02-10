package org.spring.learn.ioc.overview.container;

import org.spring.learn.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * FactoryBean 示例 {@link FactoryBean}
 * <p>创建时间: 2022/11/18 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
