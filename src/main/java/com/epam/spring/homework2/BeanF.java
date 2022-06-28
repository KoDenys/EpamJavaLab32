package com.epam.spring.homework2;

import org.springframework.stereotype.Component;

@Component
public class BeanF implements Validate{
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
