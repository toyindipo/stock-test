package com.progno.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import javax.servlet.Filter;

@EnableAutoConfiguration
@SpringBootApplication
public class StockApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}
	
	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StockApplication.class);
    }
}
