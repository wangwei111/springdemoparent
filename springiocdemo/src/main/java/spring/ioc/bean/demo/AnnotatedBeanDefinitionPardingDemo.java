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
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ObjectUtils;
import spring.entity.User;

/**
 *  beanDefinition解析 java注解AnnotatedBeanDefinitionReader
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 04/04/2020 22:51
 */
public class AnnotatedBeanDefinitionPardingDemo {

    @Bean
    private User user(){
        return  new User();
    }

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionBuilder beanDefinitionBuilder =BeanDefinitionBuilder.genericBeanDefinition(AnnotatedBeanDefinitionPardingDemo.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanFactory.registerBeanDefinition("myBeanDefinitionTest1",beanDefinition);
        AnnotatedBeanDefinitionReader beanDefinitionReader =new AnnotatedBeanDefinitionReader(beanFactory);
        int start = beanFactory.getBeanDefinitionCount();
        beanDefinitionReader.register(AnnotatedBeanDefinitionPardingDemo.class);
        beanDefinitionReader.registerBean(AnnotatedBeanDefinitionPardingDemo.class,"myBeanDefinitionTest");
        int end = beanFactory.getBeanDefinitionCount();
        System.out.println("共创建 beanDefinition数量："+(end-start));
        AnnotatedBeanDefinitionPardingDemo  demo = beanFactory.getBean("myBeanDefinitionTest",AnnotatedBeanDefinitionPardingDemo.class);
        AnnotatedBeanDefinitionPardingDemo  demo1 = beanFactory.getBean("myBeanDefinitionTest1",AnnotatedBeanDefinitionPardingDemo.class);
        System.out.println(demo);
        System.out.println(demo1);

    }

      public class instantiationAwareBeanPostProcessorDemo  implements InstantiationAwareBeanPostProcessor {
          @Override
          public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
              if (ObjectUtils.nullSafeEquals(beanName, "user") && User.class.equals(beanClass)) {
                  return new User();
              }
              return null;
          }

      }

}
