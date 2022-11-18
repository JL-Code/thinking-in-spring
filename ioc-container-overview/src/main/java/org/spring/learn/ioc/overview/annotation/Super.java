package org.spring.learn.ioc.overview.annotation;

import org.spring.learn.ioc.overview.domain.SuperUser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Super 注解，用于标注 {@link SuperUser}
 * <p>创建时间: 2022/11/17 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">codeme</a>
 * @since
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
