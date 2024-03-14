package padroes.projeto.com.spring.projetospringinitializr.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; 

//The @Repository annotation tells Spring Data JPA that this class is a repository.
@Repository 
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
