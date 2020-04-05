/**
 * *****************************************************
 * Copyright (C) 2020 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package spring.ioc.bean.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import spring.annotation.Super;
import spring.entity.SuperUser;
import spring.entity.User;
import sun.dc.pr.PRError;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 04/05/2020 18:37
 */
public class PostProcessorBeanDemo {

    @Bean
    public SuperUser superUser(){
        SuperUser superUser= new SuperUser();
        superUser.setAge(11);
        superUser.setId(user.getId());
        superUser.setName(user.getName());
        return  superUser;
    }
    @Bean
    public User user(){
        User user= new User();
        user.setId(11L);
        user.setName("小明");
        return  user;
    }


    @Autowired
    private  User user;

/*    @Autowired
    private  SuperUser superUser;*/

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(PostProcessorBeanDemo.class);
        DefaultListableBeanFactory beanFactory  =new DefaultListableBeanFactory(applicationContext);
        applicationContext.addBeanFactoryPostProcessor(beanFactory1 -> {
            System.out.println(beanFactory1.getBeanNamesIterator().next());
        });
        applicationContext.register(MyInstantiationAwareBeanPostProcessor.class);
        applicationContext.refresh();

       /* XmlBeanDefinitionReader xmlBeanDefinitionReader= new XmlBeanDefinitionReader(beanFactory);
        String xmlPath ="dependcyLookup.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlPath);*/
       // PostProcessorBeanDemo postProcessorBeanDemo = configApplicationContext.getBean(PostProcessorBeanDemo.class);

        User user = beanFactory.getBean("user",User.class);
        User superUser = beanFactory.getBean("superUser",SuperUser.class);

        System.out.println("superUser:"+superUser);
        System.out.println("user:"+user);
        applicationContext.close();

    }

    public static class MyInstantiationAwareBeanPostProcessor  implements InstantiationAwareBeanPostProcessor {
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
           if (ObjectUtils.nullSafeEquals(beanName, "user") && User.class.equals(beanClass)) {
                return new User();
            }
            return null;
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals(beanName, "superUser") && SuperUser.class.equals(bean.getClass())) {
                SuperUser user = (SuperUser) bean;
                    user.setId(22L);
                    user.setName("xiaoming");
                    return false;
            }
            return true;
        }

        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
                throws BeansException {

            return null;
        }

    }

    }
