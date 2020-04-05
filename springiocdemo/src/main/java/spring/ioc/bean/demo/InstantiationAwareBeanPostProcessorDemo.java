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
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;
import spring.entity.User;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 04/05/2020 1:41
 */
public class InstantiationAwareBeanPostProcessorDemo  implements InstantiationAwareBeanPostProcessor{

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals(beanName,"user") && User.class.equals(beanClass)){
            return  new User();
        }
        return null;
    }

}
