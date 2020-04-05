/**
 * *****************************************************
 * Copyright (C) 2020 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package spring.ioc.bean.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.annotation.Super;
import spring.entity.User;
import java.util.Map;
/**
 * ${DESCRIPTION}
 *
 * 依赖查找实例：
 * 1.通过xml名称方式来查找
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 03/28/2020 16:40
 */
public class DependencyLookupDemo {


    public static  void main(String[] args){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/dependcyLookup.xml");
        //实时查询根据类型
        lookupType(beanFactory);
        //查找到所有的user集合对象
        lookupCollectionByType(beanFactory);
        //通过注解查询
        lookupAnntationTpye(beanFactory);

        //懒加载根据id
        lookupInLazy(beanFactory);
        //实时查询根据id
        lookupRealTime(beanFactory);
    }

    private static void lookupAnntationTpye(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansWithAnnotation = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("通过注解获取对象："+beansWithAnnotation);
        }

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Object user = listableBeanFactory.getBean("user");
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有的user集合对象"+user);
            System.out.println("查找到所有的user集合对象2"+beansOfType);

        }
    }

    private static void lookupType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时加载："+user);
    }

    private static void lookupRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时加载："+user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> lazyObject = (ObjectFactory<User>) beanFactory.getBean("lazyObject");
        User object = lazyObject.getObject();
        System.out.println("延时加载："+object);
    }
}
