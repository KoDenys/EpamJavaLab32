package com.epam.spring.homework1.pet;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Dog implements Animal{
    public String getAnimal(){
        return this.getClass().getSimpleName();
    }
}
