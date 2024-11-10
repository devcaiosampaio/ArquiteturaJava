package br.edu.infnet.caio.sampaio.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.caio.sampaio.client.EnderecoClient;
import br.edu.infnet.caio.sampaio.client.LocalidadeClient;
import br.edu.infnet.caio.sampaio.model.domain.Endereco;
import br.edu.infnet.caio.sampaio.model.domain.Estado;
import br.edu.infnet.caio.sampaio.model.domain.Municipio;

@Service
public class LocalizacaoService {

	@Autowired
	private EnderecoClient enderecoClient;
	@Autowired
	private LocalidadeClient localidadeClient;

	public Endereco findByCep(String cep) {
		return enderecoClient.findByCep(cep);
	}

	public Collection<Estado> obterEstados(){
		return localidadeClient.obterEstados();
	}
	
	public Collection<Municipio> obterMunicipios(Integer uf){
		return localidadeClient.obterMunicipios(uf);
	}
}