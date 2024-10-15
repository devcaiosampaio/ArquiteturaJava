package br.edu.infnet.caio.sampaio.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.caio.sampaio.model.domain.Bibliotecario;

@Service
public class BibliotecarioService {
	private Map<String, Bibliotecario> mapBibliotecarios = new HashMap<String, Bibliotecario>();
	
	public void incluir(Bibliotecario bibliotecario) {
		mapBibliotecarios.put(bibliotecario.getNumeroFuncionario(), bibliotecario);
	}
	
	public Collection<Bibliotecario> obterLista() {
		return mapBibliotecarios.values();
	}

}
