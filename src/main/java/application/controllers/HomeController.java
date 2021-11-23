// Indica em qual pacote este Controlador estará localizado
package application.controllers;

// Importa os métodos necessários para a criação do Controlador
import org.springframework.stereotype.Controller;
// Importa o pacote de Mapeamento de Requisições do Framework Spring
import org.springframework.web.bind.annotation.RequestMapping;
// Importa o pacote de Métodos de Requisição (GET, POST, DELETE, PUT, ETC) do Framework Spring
import org.springframework.web.bind.annotation.RequestMethod;

// Indica que a classe abaixo é um Controlador (Anotação)
@Controller
// Cria a classe pública HomeController e abre o escopo de corpo dela.
public class HomeController {
    // Anotação para mapear solicitações da web em métodos em classes de tratamento de solicitações com assinaturas de método flexíveis.
    @RequestMapping(method=RequestMethod.GET)
    // Cria uma função de retorno público de tipo String com o nome index, sem parâmetros.
    public String index() {
        // Indica o retorno de uma string.
        return "home/index.jsp";
    }
}