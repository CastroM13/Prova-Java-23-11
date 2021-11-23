// Indica em qual pacote este Controlador estará localizado
package application.models;

// Diversos imports do Java X
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Especifica que a classe é uma entidade. Esta anotação é aplicada à classe de entidade.
@Entity
// Especifica a tabela primária para a entidade anotada.
@Table(name="livros")
// Cria uma classe pública nomeada Livro
public class Livro {
    // Especifica a chave primária de uma entidade.
    @Id
    // Fornece a especificação de estratégias de geração de valores de chaves primárias.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Cria uma integer privada nomeada id
    private int id;
    // Cria uma string privada nomeada titulo
    private String titulo;

    // As linhas seguintes representam a formatação GETTER e SETTER
    // que resumidamente serve como intermédio entre o valor e interações externas 

    // Este é o GET de id, obtém o id
    public int getId() {
        // Retorna o id
        return id;
    }

    // Este é o set de id, define o id
    public void setId(int id) {
        // Define o id local como o valor obtido por setId
        this.id = id;
    }

    // Este é o GET de titulo, obtém o titulo
    public String getTitulo() {
        // Retorna o titulo
        return titulo;
    }

    
    // Este é o set de titulo, define o titulo
    public void setTitulo(String titulo) {
        // Define o titulo local como o valor obtido por setTitulo
        this.titulo = titulo;
    }


    
}
