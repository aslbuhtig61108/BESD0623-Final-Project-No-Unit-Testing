package com.promineotech.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication (scanBasePackageClasses = {ComponentScanMarker.class})
@OpenAPIDefinition(info = @Info(title = "Book Entry Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server") })
public class FinalProjectPlums {

	public static void main(String[] args) {
			SpringApplication.run(FinalProjectPlums.class, args);

	}
}