package com.taike.autoconfiguration.annotation.main;

import com.taike.autoconfiguration.annotation.Import.Circle;
import com.taike.autoconfiguration.annotation.ImportSelector.Config2;
import com.taike.autoconfiguration.annotation.ImportSelector.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainImportSelector {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);
        Circle circle = context.getBean(Circle.class);
        Triangle triangle = context.getBean(Triangle.class);
        circle.sayHi();
        triangle.sayHi();
    }
}
