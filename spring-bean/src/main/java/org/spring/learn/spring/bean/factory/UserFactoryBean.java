package org.spring.learn.spring.bean.factory;

import org.spring.learn.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * TODO
 * <p>创建时间: 2022/11/19 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return User.valueOf(99L, "codeme-user-factory-bean");
    }

    @Override
    public Class<?> getObjectType() {
    return User.class;
    }
}
