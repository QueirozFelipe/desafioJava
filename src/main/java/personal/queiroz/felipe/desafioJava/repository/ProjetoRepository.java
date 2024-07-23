package personal.queiroz.felipe.desafioJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.queiroz.felipe.desafioJava.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
