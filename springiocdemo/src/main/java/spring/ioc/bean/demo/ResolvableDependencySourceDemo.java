/**
 * *****************************************************
 * Copyright (C) 2020 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package spring.ioc.bean.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 04/04/2020 1:42
 */
public class ResolvableDependencySourceDemo {

    @Autowired
    private  String value;

    @PostConstruct
    public  void init(){
        System.out.println(value);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencySourceDemo.class);
        //监听事件回掉， refresh后执行
        applicationContext.addBeanFactoryPostProcessor(beanFactory->{
            beanFactory.registerResolvableDependency(String.class,"hello world");
        });
        //不能依赖查找 只能依赖注入
        String bean = applicationContext.getBean(String.class);
        System.err.println(bean);

        applicationContext.refresh();
        applicationContext.close();
    }
}
