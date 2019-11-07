package com.taike.autoconfiguration.annotation.Import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({Circle.class})
@Configuration
public class Config {

}
