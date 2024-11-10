package br.edu.infnet.caio.sampaio.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.caio.sampaio.model.domain.Publicacao;

@Repository
public interface IPublicacaoRepository extends CrudRepository<Publicacao, Integer> {

	List<Publicacao> findByAutor(String autor);
}
