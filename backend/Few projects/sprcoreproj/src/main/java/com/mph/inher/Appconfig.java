package com.mph.inher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mph.annoconfig.GreetingServiceImpl;

@Configuration
@ComponentScan
public class Appconfig {

	@Bean("traveller")
	public Traveller getTraveller(Vehicle vehicle)
	{
		Traveller traveller = new Traveller(vehicle);
		
		return traveller;
	}
}

