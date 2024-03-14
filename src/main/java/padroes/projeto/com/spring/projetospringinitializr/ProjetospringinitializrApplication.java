package padroes.projeto.com.spring.projetospringinitializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetospringinitializrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetospringinitializrApplication.class, args);
	}

}
