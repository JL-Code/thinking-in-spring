package org.spring.learn.ioc.overview.domain;


/**
 * @author codeme
 */
public class User {

    public User() {
        name = "codeme";
        id = 10L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    private Long id;

    @Override
    public String toString() {
        return "{name:'" + this.name + "',id:" + this.id + "}";
    }

    /**
     * User 静态工厂
     *
     * @param id   用户 id
     * @param name 用户名
     * @return 一个实例化的 User 对象
     */
    public static User valueOf(Long id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static User valueOf() {
        User user = new User();
        user.setId(19L);
        user.setName("codeme-static-method");
        return user;
    }
}
