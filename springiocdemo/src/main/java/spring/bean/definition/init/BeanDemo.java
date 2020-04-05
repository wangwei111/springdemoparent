/**
 * *****************************************************
 * Copyright (C) 2020 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package spring.bean.definition.init;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * ${DESCRIPTION}
 * spring 初始化bean
 * 1.java 自带@PostConstract
 * 2.spring @Bean(initMethod='init')
 * 3.java api AbstractBeanDefinition #setInitMethodName(String)
 * @author wangwei<wwfdqc@126.com>
 * @date 03/30/2020 23:02
 */
public class BeanDemo {

    public static void main(String[] args) {


        BigDecimal a  =new BigDecimal("0");
        if (a.compareTo(BigDecimal.ZERO) ==0) {
            System.out.println("ss");
        }
      /*  AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BeanDemo.class);

        annotationConfigApplicationContext.refresh();
        annotationConfigApplicationContext.close();*/
    }

    @Bean(initMethod = "beanInit")
    public UserFactory userFactory(){
        return  new UserFactory();
    }
}
