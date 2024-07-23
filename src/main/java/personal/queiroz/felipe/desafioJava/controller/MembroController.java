package personal.queiroz.felipe.desafioJava.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.queiroz.felipe.desafioJava.dto.CadastroMembroDTO;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoMembroDTO;
import personal.queiroz.felipe.desafioJava.service.MembroService;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/membro")
public class MembroController {

    @Autowired
    MembroService membroService;

    @PostMapping
    public ResponseEntity associaMembro(@RequestBody @Valid CadastroMembroDTO dto, UriComponentsBuilder uriBuilder) {
        var membro = membroService.salvarMembro(dto);
        var uri = uriBuilder.path("/membro/{idProjeto}/{idPessoa}")
                .buildAndExpand(membro.getMembroId().getProjeto().getId(), membro.getMembroId().getPessoa().getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoMembroDTO(membro));
    }

    @DeleteMapping("/{idProjeto}/{idPessoa}")
    public ResponseEntity desassociaMembro(@PathVariable Long idProjeto, @PathVariable Long idPessoa) {
        if (membroService.deletarMembro(idProjeto, idPessoa))
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

}
