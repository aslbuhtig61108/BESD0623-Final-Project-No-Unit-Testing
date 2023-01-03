package com.promineotech.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;

@SpringBootApplication (scanBasePackageClasses = {ComponentScanMarker.class})
public class FinalProjectPlums {

	public static void main(String[] args) {
			SpringApplication.run(FinalProjectPlums.class, args);

	}
}
