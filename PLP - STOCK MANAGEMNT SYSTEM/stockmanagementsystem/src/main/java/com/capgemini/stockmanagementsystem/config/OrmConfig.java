package com.capgemini.stockmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class OrmConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
	    LocalEntityManagerFactoryBean bean=new LocalEntityManagerFactoryBean();
	    bean.setPersistenceUnitName("stockmanagement");
		
	    return bean;
	 }
	
	

}
