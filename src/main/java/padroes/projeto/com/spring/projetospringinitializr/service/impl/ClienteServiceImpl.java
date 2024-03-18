package padroes.projeto.com.spring.projetospringinitializr.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import padroes.projeto.com.spring.projetospringinitializr.model.Cliente;
import padroes.projeto.com.spring.projetospringinitializr.model.ClienteRepository;
import padroes.projeto.com.spring.projetospringinitializr.model.Endereco;
import padroes.projeto.com.spring.projetospringinitializr.model.EnderecoRepository;
import padroes.projeto.com.spring.projetospringinitializr.service.ServicoCliente;
import padroes.projeto.com.spring.projetospringinitializr.service.ServicoViaCep;
@Service
public class ClienteServiceImpl implements ServicoCliente {

    //Singleton: injects Spring components(dependencies) via @Autowired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ServicoViaCep viaCepService;

    //Facade: abstraction of the complex logic
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }
    
    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        //Converts CEP to String
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(Long.parseLong(cep)).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        //It inserts the client with the new address(or updates it if it already exists)
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}