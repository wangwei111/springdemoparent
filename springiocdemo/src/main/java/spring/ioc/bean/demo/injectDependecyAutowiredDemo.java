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
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import spring.bean.definition.init.BeanDemo;
import spring.entity.User;

/**
 *  Autowired 依赖注入描述信息
 * {@link DependencyDescriptor }
 * {@link org.springframework.beans.factory.support.DefaultListableBeanFactory }#resoleDependecy
 * @author wangwei<wwfdqc@126.com>
 * @date 04/03/2020 0:21
 */
public class injectDependecyAutowiredDemo {

    @Autowired
    public User user;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(injectDependecyAutowiredDemo.class);
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlPath ="dependcyLookup.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);
        applicationContext.refresh();
        injectDependecyAutowiredDemo demo = applicationContext.getBean(injectDependecyAutowiredDemo.class);

        System.out.println(demo.user);
        applicationContext.close();
    }
}
