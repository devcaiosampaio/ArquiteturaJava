package br.edu.infnet.caio.sampaio.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.caio.sampaio.model.domain.Bibliotecario;
import br.edu.infnet.caio.sampaio.model.domain.Endereco;
import br.edu.infnet.caio.sampaio.model.repository.IBibliotecarioRepository;

@Service
public class BibliotecarioService {
	
	@Autowired
	private IBibliotecarioRepository bibliotecarioRepository;
	@Autowired
	private LocalizacaoService localizacaoService;
	
	public Bibliotecario incluir(Bibliotecario bibliotecario) {
		
		String cep = bibliotecario.getEndereco().getCep();
		
		Endereco endereco = localizacaoService.findByCep(cep);

		bibliotecario.setEndereco(endereco);

		return bibliotecarioRepository.save(bibliotecario);
	}
	
	public boolean excluir(Integer id) {
		
		bibliotecarioRepository.deleteById(id);		
		return true;
	}
	
	public Collection<Bibliotecario> obterLista(){
		return (Collection<Bibliotecario>) bibliotecarioRepository.findAll(Sort.by(Sort.Order.asc("nome")));
	}
	
	public List<Bibliotecario> obterPorNome(String nome){
		return bibliotecarioRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}
	
	public long obterQtde() {
		return bibliotecarioRepository.count();
	}

	public Bibliotecario obterPorId(Integer id) {
		return bibliotecarioRepository.findById(id).orElse(null);
	}

}
