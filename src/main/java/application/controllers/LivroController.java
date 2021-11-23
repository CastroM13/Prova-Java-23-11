// Indica em qual pacote este Controlador estará localizado
package application.controllers;

// Improta um pacote opcional do java.util (Que possui muitas utilidades)
import java.util.Optional;

// Diversos imports do framework Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// Importa o modelo Livro da aplicação
import application.models.Livro;
// Importa o repositório LivroRepository da aplicação
import application.repositories.LivroRepository;
// Importa um kit de ui do framework spring
import org.springframework.ui.Model;

// Indica que a classe abaixo é um Controlador (Anotação)
@Controller
// Anotação para mapear solicitações da web em métodos em classes de tratamento
// de solicitações com assinaturas de método flexíveis.
@RequestMapping("/livro")
// Cria a classe pública LivroController e abre o escopo de corpo dela.
public class LivroController {
    // Marca um construtor, campo, método setter ou método de configuração para ser
    // autowired pelos recursos de injeção de dependência do Spring.
    @Autowired
    // Cria um objeto privato chamado livrosRepo do tipo LivroRepository
    private LivroRepository livrosRepo;

    // Anotação para mapear solicitações da web em métodos em classes de tratamento
    // de solicitações com assinaturas de método flexíveis.
    @RequestMapping("/list")
    // Cria uma função de retorno público de tipo String com o nome list, com o
    // parâmetro model do tipo Model, que serve para listar todos livros
    public String list(Model model) {
        // Adiciona o atributo livros ao modelo e preenche com todos livros do
        // livrosRepo
        model.addAttribute("livros", livrosRepo.findAll());
        // Retorna uma string referente à página que mostrará os dados obtidos
        return "list.jsp";

    }

    // Cria uma função de retorno público de tipo String com o nome listar, sem
    // parâmetros, que serve para listar todos livros dentro do "/livro"
    public String listar() {
        // Retorna uma string referente à página que redirecionar ao método responsável
        // pela listagem
        return "livro/list.jsp";
    }

    // Anotação para mapear solicitações da web em métodos em classes de tratamento
    // de solicitações com assinaturas de método flexíveis.
    @RequestMapping("/insert")
    // Cria uma função de retorno público de tipo String com o nome listar, sem
    // parâmetros, que serve para listar todos livros dentro do "/livro"
    public String formInsert() {
        return "insert.jsp";

    }

    // Anotação para mapear solicitações da web em métodos em classes de tratamento
    // de solicitações com assinaturas de método flexíveis, marca como essa função pode ser acessada pela web e seu método.
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    // Cria uma função de retorno público de tipo String com o nome saveInsert, que
    // recebe o título do livro como parâmetro, essa função serve para inserir
    // títulos no repositório
    public String saveInsert(@RequestParam("titulo") String titulo) {
        // Cria uma instância do objeto chamado livro do tipo Livro
        Livro livro = new Livro();
        // Define o título do livro com o parâmetro recebido
        livro.setTitulo(titulo);
        // Salva o livro no repositório
        livrosRepo.save(livro);
        // Retorna um redirecionamento pra voltar pra lista após a inserção
        return "redirect:/livro/list";

    }

    // Anotação para mapear solicitações da web em métodos em classes de tratamento
    // de solicitações com assinaturas de método flexíveis, marca como essa função pode ser acessada pela web.
    @RequestMapping("/delete/{id}")
    // Cria uma função de retorno público de tipo String com o nome formDelete, que
    // recebe o id do livro como parâmetro, essa função serve para confirmar
    // se é possível remover títulos do repositório
    public String formDelete(Model model, @PathVariable int id) {
        // Busca o livro pelo id e marca campo como opcional pra caso o id não seja encontrado
        Optional<Livro> livro = livrosRepo.findById(id);
        // Define se o livro não for presente, o usuário será redirecionado de volta pra página que está
        if (!livro.isPresent())
            // Define qual a rota do redirecionamento
            return "redirect:/livro/list";
        // Adiciona o atributo livro ao model e preenche com o livro obtido
        model.addAttribute("livro", livro.get());
        // Redireciona para a página de exclusão
        return "/livro/delete.jsp";

    }

    // Anotação para mapear solicitações da web em métodos em classes de tratamento
    // de solicitações com assinaturas de método flexíveis, marca como essa função pode ser acessada pela web e seu método.
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    // Cria uma função de retorno público de tipo String com o nome confirmDelete, que
    // recebe o id do livro como parâmetro, essa função serve para remover
    // títulos do repositório
    public String confirmDelete(@RequestParam("id") int id) {
        // Executa a função de remover o livro pelo id do repositório de livros
        livrosRepo.deleteById(id);
        // Redireciona o usuário de volta para a lista de livros
        return "redirect:/livro/list";

    }

    // Anotação para mapear solicitações da web em métodos em classes de tratamento
    // de solicitações com assinaturas de método flexíveis, marca como essa função pode ser acessada pela web.
    @RequestMapping("/update/{id}")
    // Cria uma função de retorno público de tipo String com o nome formUpdate, que
    // recebe o id do livro e o modelo como parâmetro, essa função serve para confirmar
    // se é possível atualizar títulos do repositório
    public String formUpdate(Model model, @PathVariable int id) {
        // Busca o livro pelo id e marca campo como opcional pra caso o id não seja encontrado
        Optional<Livro> livro = livrosRepo.findById(id);
        // Define se o livro não for presente, o usuário será redirecionado de volta pra página que está
        if (!livro.isPresent())
            // Define qual a rota do redirecionamento
            return "redirect:/livro/list";
        // Adiciona o atributo livro ao model e preenche com o livro obtido
        model.addAttribute("livro", livro.get());
        // Redireciona para a página de atualização
        return "/livro/update.jsp";

    }

    // Anotação para mapear solicitações da web em métodos em classes de tratamento
    // de solicitações com assinaturas de método flexíveis, marca como essa função pode ser acessada pela web e seu método.
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    // Cria uma função de retorno público de tipo String com o nome confirmDelete, que
    // recebe o id do livro como parâmetro, essa função serve para atualizar títulos do repositório
    public String saveUpdate(@RequestParam("titulo") String titulo, @RequestParam("id") int id) {
        // Busca o livro pelo id e marca campo como opcional pra caso o id não seja encontrado
        Optional<Livro> livro = livrosRepo.findById(id);
        // Define se o livro não for presente, o usuário será redirecionado de volta pra página que está
        if (!livro.isPresent())
            return "redirect:/livro/list";
        // Obtém o livro e atualiza seu título
        livro.get().setTitulo(titulo);
        // Salva o livro no repositório
        livrosRepo.save(livro.get());
        // Redireciona o usuário de volta pra lista de livros
        return "redirect:/livro/list";

    }
}