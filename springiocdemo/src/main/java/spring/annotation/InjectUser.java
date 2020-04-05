package spring.annotation;

import java.lang.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 04/03/2020 23:27
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD,  ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectUser {
}
