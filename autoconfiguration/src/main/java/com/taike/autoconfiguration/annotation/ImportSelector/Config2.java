package com.taike.autoconfiguration.annotation.ImportSelector;


import com.taike.autoconfiguration.annotation.Import.Circle;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({Circle.class, MyImportSelector.class})
@Configuration
public class Config2 {

}
