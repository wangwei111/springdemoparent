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
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.InjectUser;
import spring.annotation.MyAutowired;
import spring.entity.User;

import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.springframework.context.annotation.AnnotationConfigUtils.CONFIGURATION_BEAN_NAME_GENERATOR;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 04/03/2020 23:17
 */
@Configuration
public class AutowiredAnnotationDemo {


    @Autowired
    private User autowiredUser;

    @MyAutowired
    private User myAutowiredUser;

    @InjectUser
    private  User injectUser;

    /**
     * static bean提前编译
     * @return
     */
    @Bean(name = CONFIGURATION_BEAN_NAME_GENERATOR)
    public static AutowiredAnnotationBeanPostProcessor setAutowiredAnnotaionBeanPostProcessor(){
        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor() ;
        Set<Class<? extends  Annotation> > set = new LinkedHashSet<Class<? extends Annotation>>(asList(Autowired.class,InjectUser.class,MyAutowired.class));
       autowiredAnnotationBeanPostProcessor.setAutowiredAnnotationTypes(set);
      // autowiredAnnotationBeanPostProcessor.setAutowiredAnnotationType(InjectUser.class);
        return autowiredAnnotationBeanPostProcessor;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =new AnnotationConfigApplicationContext();
        configApplicationContext.register(AutowiredAnnotationDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader= new XmlBeanDefinitionReader(configApplicationContext);
        String xmlPath ="dependcyLookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlPath);
        configApplicationContext.refresh();
        AutowiredAnnotationDemo autowiredAnnotationDemo = configApplicationContext.getBean(AutowiredAnnotationDemo.class);
        System.out.println("autowiredUser:"+autowiredAnnotationDemo.autowiredUser);
        //自定义注解
        System.out.println("myAutowiredUser:"+autowiredAnnotationDemo.myAutowiredUser);
        System.out.println("injectUser:"+autowiredAnnotationDemo.injectUser);
        configApplicationContext.close();

    }
}
