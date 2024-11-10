package br.edu.infnet.caio.sampaio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import br.edu.infnet.caio.sampaio.model.service.BibliotecarioService;
import br.edu.infnet.caio.sampaio.model.service.LivroDigitalService;
import br.edu.infnet.caio.sampaio.model.service.LivroFisicoService;
import br.edu.infnet.caio.sampaio.model.service.PublicacaoService;

@Controller
public class AppController {
	
	@Autowired
	private BibliotecarioService bibliotecarioService;
	@Autowired
	private PublicacaoService publicacaoService;
	@Autowired
	private LivroDigitalService livroDigitalService;
	@Autowired
	private LivroFisicoService livroFisicoService;

	@GetMapping(value = "/")
	public String telaHome(Model model) {

		model.addAttribute("qtdeBibliotecarior", bibliotecarioService.obterQtde());
		model.addAttribute("qtdePublicacao", publicacaoService.obterQtde());
		model.addAttribute("qtdeLivroDigital", livroDigitalService.obterQtde());
		model.addAttribute("qtdeLivroFisico", livroDigitalService.obterQtde());

		return "home";
	}
	
	@GetMapping(value = "/bibliotecario/listagem")
	public String bibliotecarioLista(Model model) {
				
		model.addAttribute("titulo", "Listagem de Bibliotecários");
		model.addAttribute("listagem", bibliotecarioService.obterLista());
		
		return telaHome(model);
	}

	@GetMapping(value = "/publicacao/listagem")
	public String publicacaoLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de Publicações");
		model.addAttribute("listagem", publicacaoService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/livro-digital/listagem")
	public String livroDigitalLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de Publicações Digitais");
		model.addAttribute("listagem", livroDigitalService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/livro-fisico/listagem")
	public String livroFisicoLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de Publicações Fisicas");
		model.addAttribute("listagem", livroFisicoService.obterLista());
		
		return telaHome(model);
	}
}