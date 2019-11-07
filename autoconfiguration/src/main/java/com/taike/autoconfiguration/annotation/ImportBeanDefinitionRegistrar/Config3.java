package com.taike.autoconfiguration.annotation.ImportBeanDefinitionRegistrar;

import com.taike.autoconfiguration.annotation.Import.Circle;
import com.taike.autoconfiguration.annotation.ImportSelector.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({Circle.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
public class Config3 {
    
}
