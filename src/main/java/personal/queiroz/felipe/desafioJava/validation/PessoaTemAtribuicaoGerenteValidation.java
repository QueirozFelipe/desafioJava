package personal.queiroz.felipe.desafioJava.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import personal.queiroz.felipe.desafioJava.dto.CadastroProjetoDTO;
import personal.queiroz.felipe.desafioJava.exception.BusinessRuleException;
import personal.queiroz.felipe.desafioJava.repository.PessoaRepository;

@Component
public class PessoaTemAtribuicaoGerenteValidation implements CadastrarProjetoValidation {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void validar(CadastroProjetoDTO dto) {
        if (!pessoaRepository.existsByIdAndGerenteTrue(dto.idGerente())) {
            throw new BusinessRuleException("Pessoa escolhida não tem atribuição de gerente.");
        }
    }
}
