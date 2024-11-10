package br.edu.infnet.caio.sampaio.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.caio.sampaio.model.domain.Bibliotecario;

@Repository
public interface IBibliotecarioRepository extends CrudRepository<Bibliotecario, Integer>{

	List<Bibliotecario> findByNomeContaining(String nome, Sort by);
	Iterable<Bibliotecario> findAll(Sort by);
}
