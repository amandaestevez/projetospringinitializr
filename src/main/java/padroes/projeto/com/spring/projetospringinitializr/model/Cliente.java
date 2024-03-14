package padroes.projeto.com.spring.projetospringinitializr.model;

// Using JPA for database persistence to interact with the database in a standardized way

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/*This annotation is used to mark a class as an entity (JPA).
 * The class is mapped to a table in the database.
 * It represents a table in a database, and each instance of this class/entity represents a row in the table.
 */
@Entity
public class Cliente {

    @Id //this annotation is used to mark the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //
    private Long id;
    private String nome;
    @ManyToOne
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
