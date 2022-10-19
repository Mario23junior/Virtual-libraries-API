package com.api.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.library.carga.carga;

@Configuration
@Profile("dev")
public class ConfigCargaPowerActive {
   
	@Autowired
	private carga carga;
	
	@Bean
	public void CargaBaseActive() {
		this.carga.dateBasePower();
	}
}
