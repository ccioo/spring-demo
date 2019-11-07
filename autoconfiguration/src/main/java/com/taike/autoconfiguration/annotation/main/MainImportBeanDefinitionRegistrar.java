package com.taike.autoconfiguration.annotation.main;

import com.taike.autoconfiguration.annotation.Import.Circle;
import com.taike.autoconfiguration.annotation.ImportBeanDefinitionRegistrar.Config3;
import com.taike.autoconfiguration.annotation.ImportBeanDefinitionRegistrar.Rectangle;
import com.taike.autoconfiguration.annotation.ImportSelector.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainImportBeanDefinitionRegistrar {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config3.class);
        Circle circle = context.getBean(Circle.class);
        Triangle triangle = context.getBean(Triangle.class);
        Rectangle rectangle = context.getBean(Rectangle.class);
        circle.sayHi();
        triangle.sayHi();
        rectangle.sayHi();

    }

}
