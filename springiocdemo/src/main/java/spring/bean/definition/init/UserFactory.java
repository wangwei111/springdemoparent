/**
 * *****************************************************
 * Copyright (C) 2020 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package spring.bean.definition.init;

import javafx.fxml.Initializable;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 03/30/2020 23:07
 */
public class UserFactory implements InitializingBean{

    @PostConstruct
    public void init(){
        System.out.println("postConstruct 初始化bean");
    }

    public  void beanInit(){
        System.out.println("bean initMethod 初始化bean");
    }
    public  void beanInit1(){
        System.out.println("AbstractBean 初始化bean");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 初始化bean");
    }
}
