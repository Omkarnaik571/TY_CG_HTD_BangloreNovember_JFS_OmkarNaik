package com.capgemini.moduletesttwo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
@Configuration
public class OrmConfig {

	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
	    LocalEntityManagerFactoryBean bean=new LocalEntityManagerFactoryBean();
	    bean.setPersistenceUnitName("moduletest-two");
		
	    return bean;
	 }
	
	
}
