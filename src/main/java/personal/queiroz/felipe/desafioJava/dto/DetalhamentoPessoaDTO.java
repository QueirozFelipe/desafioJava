package personal.queiroz.felipe.desafioJava.dto;

import personal.queiroz.felipe.desafioJava.model.Pessoa;

import java.time.LocalDate;

public record DetalhamentoPessoaDTO(Long id, String nome, LocalDate dataNascimento, String cpf, Boolean funcionario, Boolean gerente) {

    public DetalhamentoPessoaDTO(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getCpf(), pessoa.getFuncionario(), pessoa.getGerente());
    }

}
