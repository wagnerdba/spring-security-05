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
		return "<html>" +
				"<head>" +
				"<title>Acesso Autorizado</title>" +
				"<style>" +
				"  body {" +
				"    font-family: Arial, sans-serif;" +
				"    background-color: #f4f7f6;" +
				"    display: flex;" +
				"    justify-content: center;" +
				"    align-items: center;" +
				"    height: 100vh;" +
				"    margin: 0;" +
				"  }" +
				"  .container {" +
				"    text-align: center;" +
				"    background-color: #ffffff;" +
				"    padding: 50px;" +
				"    border-radius: 10px;" +
				"    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);" +
				"    max-width: 600px;" +
				"  }" +
				"  h1 {" +
				"    color: #4CAF50;" +
				"    font-size: 36px;" +
				"    margin-bottom: 20px;" +
				"  }" +
				"  p {" +
				"    font-size: 18px;" +
				"    color: #555555;" +
				"    margin-top: 0;" +
				"  }" +
				"</style>" +
				"</head>" +
				"<body>" +
				"  <div class='container'>" +
				"    <h1>ROTA PRIVADA. ACESSO AUTORIZADO!</h1>" +
				"    <p>Bem-vindo ao sistema. Você tem permissão para acessar este conteúdo.</p>" +
				"  </div>" +
				"</body>" +
				"</html>";
	}
}

