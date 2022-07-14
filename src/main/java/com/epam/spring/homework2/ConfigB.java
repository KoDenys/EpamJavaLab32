package com.epam.spring.homework2;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

@Configuration
@Import(ConfigA.class)
public class ConfigB {

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    public BeanB beanB() {
        return new BeanB();
    }

    @DependsOn({"BeanD", "BeanB"})
    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }
    @Bean
    public BeanFactoryPP beanFactoryPP() {
        return new BeanFactoryPP();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
