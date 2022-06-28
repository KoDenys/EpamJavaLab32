package com.epam.spring.homework1.pet;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal{
    public String getAnimal(){
        return this.getClass().getSimpleName();
    }
}
