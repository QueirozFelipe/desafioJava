package personal.queiroz.felipe.desafioJava.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Table(name = "membros")
@Entity(name = "Membro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Membro {

    @EmbeddedId
    private MembroId membroId;

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    public static class MembroId implements Serializable {
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idprojeto")
        private Projeto projeto;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idpessoa")
        private Pessoa pessoa;

    }

}
