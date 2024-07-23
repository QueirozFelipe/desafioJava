package personal.queiroz.felipe.desafioJava.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import personal.queiroz.felipe.desafioJava.dto.CadastroPessoaDTO;
import personal.queiroz.felipe.desafioJava.exception.BusinessRuleException;
import personal.queiroz.felipe.desafioJava.repository.PessoaRepository;

@Component
public class CpfNaoPodeSerIgualValidation implements CadastrarPessoaValidation {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void validar(CadastroPessoaDTO dto) {
        if (pessoaRepository.existsByCpf(dto.cpf())) {
            throw new BusinessRuleException("CPF já pertence a uma pessoa cadastrada!");
        }
    }
}
