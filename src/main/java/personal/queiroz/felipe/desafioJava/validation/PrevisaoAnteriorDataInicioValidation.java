package personal.queiroz.felipe.desafioJava.validation;

import org.springframework.stereotype.Component;
import personal.queiroz.felipe.desafioJava.dto.CadastroProjetoDTO;
import personal.queiroz.felipe.desafioJava.exception.BusinessRuleException;

@Component
public class PrevisaoAnteriorDataInicioValidation implements CadastrarProjetoValidation {
    @Override
    public void validar(CadastroProjetoDTO dto) {
        if (dto.dataPrevisaoFim().isBefore(dto.dataInicio())) {
            throw new BusinessRuleException("Data de previsão de término não pode ser menor que a data de início!");
        }
    }
}
