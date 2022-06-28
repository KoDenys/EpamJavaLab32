package com.epam.spring.homework2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Validate) {
            try {

                Field fieldName = bean.getClass().getDeclaredField("name");
                Field fieldValue = bean.getClass().getDeclaredField("value");

                fieldName.setAccessible(true);
                fieldValue.setAccessible(true);

                if (fieldName.get(bean) == null)
                    System.out.println("[VALIDATION] In bean \""+beanName+"\" field \"name\" should be not null!");
                if (fieldValue.getInt(bean) <= 0)
                    System.out.println("[VALIDATION] In bean \""+beanName+"\" field \"value\" should be positive!");

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

}
