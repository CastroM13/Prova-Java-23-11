// Define o pacote da aplicação como application
package application;

// Importa dois utilitários do framework Spring
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Indica uma classe de configuração que declara um ou mais métodos @Bean
// e também dispara a configuração automática e a varredura de componente.
@SpringBootApplication
// Cria uma classe pública nomeada Application (Aplicação prinipal)
public class Application {
    // Cria um método estático sem retorno que define a inicialização da aplicação
    public static void main(String[] args) {
        // Roda a aplicação Spring
        SpringApplication.run(Application.class, args);
    }
}