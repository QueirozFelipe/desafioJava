package personal.queiroz.felipe.desafioJava.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import personal.queiroz.felipe.desafioJava.dto.AtualizacaoPessoaDTO;
import personal.queiroz.felipe.desafioJava.dto.CadastroPessoaDTO;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoPessoaDTO;
import personal.queiroz.felipe.desafioJava.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/")
    public ResponseEntity cadastraPessoa(@RequestBody @Valid CadastroPessoaDTO cadastroPessoaDTO, UriComponentsBuilder uriBuilder) {
        var pessoa = pessoaService.salvarPessoa(cadastroPessoaDTO);
        var uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoPessoaDTO(pessoa));
    }

    @GetMapping
    public ResponseEntity listarPessoas() {
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharPessoaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.detalharPessoa(id));
    }

    @PutMapping("{id}/atualizar")
    public ResponseEntity atualizarPessoa(@PathVariable Long id, @RequestBody @Valid AtualizacaoPessoaDTO atualizacaoPessoaDTO) {
        return ResponseEntity.ok(pessoaService.atualizarPessoa(id, atualizacaoPessoaDTO));
    }

    @DeleteMapping("/{id}/deletar")
    public ResponseEntity deletarPessoa(@PathVariable Long id) {
        if (pessoaService.deletarPessoa(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }


}
