package personal.queiroz.felipe.desafioJava.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Desafio Java - Dev Fullstack")
                        .description("Desafio para novos Devs Fullstack Java")
                        .contact(new Contact()
                                .name("Felipe Queiroz")
                                .email("felipedsqueiroz94@gmail.com")));
    }

}
