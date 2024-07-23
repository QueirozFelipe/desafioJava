package personal.queiroz.felipe.desafioJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.queiroz.felipe.desafioJava.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    public Pessoa findByIdAndFuncionarioTrue(Long id);

    public boolean existsByIdAndGerenteTrue(Long id);

    public boolean existsByCpf(String cpf);

}
