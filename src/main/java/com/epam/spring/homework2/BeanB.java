package com.epam.spring.homework2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:prop.properties")
public class BeanB implements Validate{
    @Value(value="${BeanB.name}")
    private String name;
    @Value(value="${BeanB.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void myInitMethod() {
        System.out.println("My initMethod BeanB");
    }

    private void myOtherInitMethod() {
        System.out.println("My other initMethod BeanB");
    }

    private void myDestroyMethod() {
        System.out.println("My destroyMethod BeanB");
    }
}
