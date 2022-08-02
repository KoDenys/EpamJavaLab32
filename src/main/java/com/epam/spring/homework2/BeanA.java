package com.epam.spring.homework2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements Validate, InitializingBean, DisposableBean {
    @Value(value="BA")
    private String name;
    @Value(value="-5")
    private int value;

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy BeanA");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Properties Set BeanA");
    }
}
