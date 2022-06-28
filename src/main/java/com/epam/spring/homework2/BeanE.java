package com.epam.spring.homework2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE implements Validate{
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @PostConstruct
    public void myPostConstruct(){
        System.out.println("My Post Construct BeanE");
    }

    @PreDestroy
    public void myPreDestroy(){
        System.out.println("My PreDestroy BeanE");
    }

}
