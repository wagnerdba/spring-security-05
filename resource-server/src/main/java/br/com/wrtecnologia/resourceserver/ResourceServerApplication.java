package br.com.wrtecnologia.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}
}

@RestController
@RequestMapping("/api")
class ApiController {

	@GetMapping("/hello")
	public String hello() {
		return "<h1>Rota Privada. Acesso Concedido!</h1>";
	}
}

