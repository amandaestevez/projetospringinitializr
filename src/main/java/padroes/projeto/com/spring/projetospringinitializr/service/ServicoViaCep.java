package padroes.projeto.com.spring.projetospringinitializr.service;

/*
The following annotation declares that the interface will interact with a remote HTTP service through OpenFeign.
OpenFeign is a framework to simplify the creation of REST clients in Spring applications.
*/
import org.springframework.cloud.openfeign.FeignClient; 

/*
 * This package contains annotations designed for handling web requests
 * and defining how methods within Spring applications should respond to them.
 * 
 */
import org.springframework.web.bind.annotation.GetMapping; 

import org.springframework.web.bind.annotation.PathVariable;

import padroes.projeto.com.spring.projetospringinitializr.model.Endereco;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
 * <b>ViaCEP</b>.
 * 
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 * 
 */


@FeignClient(name = "viacep", url = "viacep.com.br/ws")
public interface ServicoViaCep {

    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}
