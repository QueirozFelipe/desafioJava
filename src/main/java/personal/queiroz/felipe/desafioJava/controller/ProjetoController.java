package personal.queiroz.felipe.desafioJava.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import personal.queiroz.felipe.desafioJava.dto.*;
import personal.queiroz.felipe.desafioJava.model.Projeto;
import personal.queiroz.felipe.desafioJava.service.MembroService;
import personal.queiroz.felipe.desafioJava.service.ProjetoService;

import java.util.List;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private MembroService membroService;

    @PostMapping("/")
    public ResponseEntity cadastraProjeto(@RequestBody @Valid CadastroProjetoDTO dto, UriComponentsBuilder uriBuilder) {
        var projeto = projetoService.salvarProjeto(dto);
        var uri = uriBuilder.path("/projeto/{id}").buildAndExpand(projeto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoProjetoDTO(projeto));
    }

    @GetMapping
    public ResponseEntity listarProjetos() {
        return ResponseEntity.ok(projetoService.listarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharProjetoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.detalharProjeto(id));
    }

    @PutMapping("{id}/atualizar")
    public ResponseEntity atualizarProjeto(@PathVariable Long id, @RequestBody @Valid AtualizacaoProjetoDTO dto) {
        return ResponseEntity.ok(projetoService.atualizarProjeto(id, dto));
    }

    @DeleteMapping("{id}/deletar")
    public ResponseEntity deletarProjeto(@PathVariable Long id) {
        if (projetoService.deletarProjeto(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/membro")
    public ResponseEntity listarMembros(@PathVariable Long id) {
        return ResponseEntity.ok(membroService.listarMembrosPorProjeto(id));
    }

}
