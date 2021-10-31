/**
 * 
 */
package com.venkat.practice;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author VenkaT
 *
 */
@Configuration
public class AppConfiguration {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
