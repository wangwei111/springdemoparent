/**
 * *****************************************************
 * Copyright (C) 2020 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import spring.entity.User;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * ${DESCRIPTION}
 * bean definition   元配置
 * @author wangwei<wwfdqc@126.com>
 * @date 03/29/2020 23:17
 */
public class BeanDefinitionDemo {

    @PostConstruct
    public  void init(){

    }

    public static  void main(String[] str){
        //1.通过beanDefinitionBuilder构建
        //genericBeanDefinition 通用bean
        BeanDefinitionBuilder beanDefinitionBuilder =  BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // rootBeanDefinition root bean
        BeanDefinitionBuilder.rootBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",1)
                .addPropertyValue("name","xiaoming");
        //获取beanDefinition实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        //1.通过AbstractBranDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues =new MutablePropertyValues();
        mutablePropertyValues.add("id",1).add("name","xiaoming");
        // mutablePropertyValues.addPropertyValue("id",1);
        //mutablePropertyValues.addPropertyValue("name","xiaoming");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);


    }
}
