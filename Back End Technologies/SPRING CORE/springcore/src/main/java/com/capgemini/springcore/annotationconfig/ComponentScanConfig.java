package com.capgemini.springcore.annotationconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.capgemini.springcore.beans")
public class ComponentScanConfig {
  	
}
