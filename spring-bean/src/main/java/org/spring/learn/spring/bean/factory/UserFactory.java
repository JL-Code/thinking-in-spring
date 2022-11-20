package org.spring.learn.spring.bean.factory;

import org.spring.learn.ioc.overview.domain.User;

/**
 * TODO
 * <p>创建时间: 2022/11/19 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
public interface UserFactory {
    /**
     * 创建一个用户实例
     *
     * @return 一个用户实例对象
     */
    default User createInstance() {
        return User.valueOf(112L, "user-instance-factory");
    }

    /**
     * 内部初始化方法：由容器调用
     */
    void innerInit();

    /**
     * 内部销毁方法：由容器调用
     */
    void innerDestroy();
}
