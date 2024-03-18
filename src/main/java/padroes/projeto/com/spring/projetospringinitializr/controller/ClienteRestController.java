package padroes.projeto.com.spring.projetospringinitializr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padroes.projeto.com.spring.projetospringinitializr.model.Cliente;
import padroes.projeto.com.spring.projetospringinitializr.service.ServicoCliente;

/*
 * This @RestController represents the Facade design pattern.
 * It abstracts all the complexity of the integration between the DB and the ViaCep API
 * in a simple and comprehensible interface (API REST)
 */

@RestController //
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired //dependency injection
    private ServicoCliente servicoCliente;

    @GetMapping //maps HTTP GET requests onto specific handler methods. 
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(servicoCliente.buscarTodos());
    }

    /*
     * ResponseEntity is a class that contains HTTP response headers and body.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicoCliente.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        ServicoCliente.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        ServicoCliente.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ServicoCliente.deletar(id);
        return ResponseEntity.ok().build();
    }
}
