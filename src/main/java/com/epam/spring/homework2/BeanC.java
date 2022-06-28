package com.epam.spring.homework2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:prop.properties")
public class BeanC implements Validate{
    @Value(value="${BeanC.name}")
    private String name;
    @Value(value="${BeanC.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void myInitMethod() {
        System.out.println("My initMethod BeanC");
    }

    private void myDestroyMethod() {
        System.out.println("My destroyMethod BeanC");
    }
}
