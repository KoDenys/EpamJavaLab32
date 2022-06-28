package com.epam.spring.homework2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPP implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            if(beanName.equals("beanB")){
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                beanDefinition.setInitMethodName("myOtherInitMethod");
                System.out.println("BeanFactoryPostProcessor changed init method in "+beanName);
            }
        }
    }
}
