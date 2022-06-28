package com.epam.spring.homework2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigB.class);
        Arrays.stream(appContext.getBeanDefinitionNames()).forEachOrdered(System.out::println);
        ((ConfigurableApplicationContext) appContext).close();

    }
}
