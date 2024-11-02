package com.ejemplo.TipoCambioBackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TipoCambioBackendApplication {

	 @GetMapping("/hello")
   public String hello(){
       return "Hola Mundo";
   }

	public static void main(String[] args) {
		SpringApplication.run(TipoCambioBackendApplication.class, args);
	}

}
