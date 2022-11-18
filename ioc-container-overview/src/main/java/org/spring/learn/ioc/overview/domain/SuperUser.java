package org.spring.learn.ioc.overview.domain;

import org.spring.learn.ioc.overview.annotation.Super;

/**
 * 超级用户, 继承自 {@link User}
 * <p>创建时间: 2022/11/17 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
