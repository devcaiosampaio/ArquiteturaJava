package br.edu.infnet.caio.sampaio;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.caio.sampaio.model.domain.Bibliotecario;
import br.edu.infnet.caio.sampaio.model.domain.Endereco;
import br.edu.infnet.caio.sampaio.model.domain.Estado;
import br.edu.infnet.caio.sampaio.model.domain.LivroDigital;
import br.edu.infnet.caio.sampaio.model.domain.LivroFisico;
import br.edu.infnet.caio.sampaio.model.domain.Municipio;
import br.edu.infnet.caio.sampaio.model.service.BibliotecarioService;
import br.edu.infnet.caio.sampaio.model.service.LocalizacaoService;
import br.edu.infnet.caio.sampaio.model.service.PublicacaoService;

@Component
public class Loader implements ApplicationRunner {
	@Autowired
	private BibliotecarioService bibliotecarioService;
	
	@Autowired
	private LocalizacaoService  localizacaoService ;
	
	@Autowired
	private PublicacaoService publicacaoService;
	
	
	
	public void run(ApplicationArguments args) throws Exception {
		for(Estado estado : localizacaoService.obterEstados()) {
			System.out.println("ESTADO: " + estado.getNome());
		}
		
		for(Municipio municipio : localizacaoService.obterMunicipios(33)) {
			System.out.println("MUNICÍPIO: " + municipio.getNome());
		}
		
		FileReader file = new FileReader("files/bibliotecarios.txt");
		BufferedReader reader = new BufferedReader(file);
		
		String linha = reader.readLine();
		
		Bibliotecario bibliotecario = null;
		while(linha != null) {
			String[] campos = linha.split(";");
			switch(campos[0].toUpperCase()) {
			case "B":
				Endereco endereco = new Endereco(campos[4]);
				
				bibliotecario = new Bibliotecario(campos[1], campos[2], campos[3]);
				bibliotecario.setEndereco(endereco);
				bibliotecarioService.incluir(bibliotecario);
				
				
				break;
			case "D":
				LivroDigital livroDigital = new LivroDigital(campos[1], campos[2], campos[3],campos[4], Double.parseDouble(campos[5]));
				livroDigital.setBibliotecario(bibliotecario);
				publicacaoService.incluir(livroDigital);
				bibliotecario.getListaPublicacoes().add(livroDigital);
				break;
			case "F":
				LivroFisico livroFisico = new LivroFisico(campos[1], campos[2], campos[3], Double.parseDouble(campos[4]), Integer.parseInt(campos[5]));
				livroFisico.setBibliotecario(bibliotecario);
				publicacaoService.incluir(livroFisico);	
				bibliotecario.getListaPublicacoes().add(livroFisico);
				break;
			}
			linha = reader.readLine();
		}
		
		for(Bibliotecario b: bibliotecarioService.obterLista()) {
			System.out.println("Bibliotecario cadastrado com sucesso: " + b);
		}
		reader.close();
	}

}
