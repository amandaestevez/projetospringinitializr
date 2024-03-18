package padroes.projeto.com.spring.projetospringinitializr.service;

import padroes.projeto.com.spring.projetospringinitializr.model.Cliente;

public interface ServicoCliente {

    /*
    The following line retrieves all "Cliente" objects and returns them as an Iterable.
    Iterable is a Java interface that allows you to access each element one by one.
    */

    Iterable<Cliente> buscarTodos();

    /*
    This method takes a Long value representing a customer's ID (defined as primary key)
    and returns the client associated with that ID.
    */

    Cliente buscarPorId(Long id);

    /*
    This method takes a "Cliente" object as an input and inserts it into the system
    creating a new customer record.
    */
    
    void inserir(Cliente cliente);
    /*
    This method updates an existing customer record with the ID
    and client object that was provided.
     */    
    void atualizar(Long id, Cliente cliente);
    
    void deletar(Long id);

}
