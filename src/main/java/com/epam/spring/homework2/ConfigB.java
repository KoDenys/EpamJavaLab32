package com.epam.spring.homework2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

@Configuration
@Import(ConfigA.class)
public class ConfigB {
    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    @Order(1)
    public BeanD beanD(){
        return new BeanD();
    }

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    @Order(2)
    public BeanB beanB(){
        return new BeanB();
    }

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    @Order(3)
    public BeanC beanC(){
        return new BeanC();
    }

    @Bean
    @Lazy
    public BeanF beanF(){
        return new BeanF();
    }
    @Bean
    public BeanFactoryPP beanFactoryPP(){
        return new BeanFactoryPP();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }


}
