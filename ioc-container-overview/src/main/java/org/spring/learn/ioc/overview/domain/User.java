package org.spring.learn.ioc.overview.domain;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

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
}
