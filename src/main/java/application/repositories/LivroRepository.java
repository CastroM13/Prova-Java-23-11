package application.repositories;
import org.springframework.data.repository.CrudRepository;

import application.models.Livro;

// Cria uma interface de armazenamento com a extensão do repositório CRUD.
public interface LivroRepository extends CrudRepository<Livro, Integer> {

    

}