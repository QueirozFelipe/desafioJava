package personal.queiroz.felipe.desafioJava.dto;

import personal.queiroz.felipe.desafioJava.model.Membro;

public record DetalhamentoMembroDTO(Long idProjeto, Long idPessoa) {

    public DetalhamentoMembroDTO(Membro membro) {
        this(membro.getMembroId().getProjeto().getId(), membro.getMembroId().getPessoa().getId());
    }

}
