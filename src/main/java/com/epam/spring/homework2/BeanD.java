package com.epam.spring.homework2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:prop.properties")
public class BeanD implements Validate{
    @Value(value="${BeanD.name}")
    private String name;
    @Value(value="${BeanD.value}")
    private int value;
    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void myInitMethod() {
        System.out.println("My initMethod BeanD");
    }

    private void myDestroyMethod() {
        System.out.println("My destroyMethod BeanD");
    }
}
