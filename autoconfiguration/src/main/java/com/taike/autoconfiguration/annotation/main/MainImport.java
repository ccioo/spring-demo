package com.taike.autoconfiguration.annotation.main;

import com.taike.autoconfiguration.annotation.Import.Circle;
import com.taike.autoconfiguration.annotation.Import.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainImport {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Circle circle = context.getBean(Circle.class);
        circle.sayHi();

    }
}
