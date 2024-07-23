package personal.queiroz.felipe.desafioJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import personal.queiroz.felipe.desafioJava.model.Membro;

import java.util.List;

public interface MembroRepository extends JpaRepository<Membro, Membro.MembroId> {


    @Query("SELECT COUNT(m) > 0 FROM Membro m WHERE m.membroId.projeto.id = :idProjeto AND m.membroId.pessoa.id = :idPessoa")
    boolean existsByIdProjetoAndIdPessoa(@Param("idProjeto") Long idProjeto, @Param("idPessoa") Long idPessoa);

    @Modifying
    @Query("DELETE FROM Membro m WHERE m.membroId.projeto.id = :idProjeto AND m.membroId.pessoa.id = :idPessoa")
    void deleteByIdProjetoAndIdPessoa(@Param("idProjeto") Long idProjeto, @Param("idPessoa") Long idPessoa);

    @Query("SELECT m FROM Membro m WHERE m.membroId.projeto.id = :idProjeto")
    List<Membro> findByIdProjeto(@Param("idProjeto") Long idProjeto);
}
