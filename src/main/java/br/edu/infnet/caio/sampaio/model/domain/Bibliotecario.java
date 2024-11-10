package br.edu.infnet.caio.sampaio.model.domain;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_bibliotecario")
public class Bibliotecario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@NotBlank(message = "O nome do vendedor é obrigatório.")
	@Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
    private String nome;
    private String numeroFuncionario;
    private String email;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idBibliotecario")
    @JsonManagedReference
    private List<Publicacao> listaPublicacoes;
   
    // Construtors
    public Bibliotecario() {
    	this.nome = "";
    	this.numeroFuncionario = "";
        this.email = "";
        this.endereco = null;
        this.listaPublicacoes = new ArrayList<Publicacao>();
    }
    
    public Bibliotecario(String nome, String numeroFuncionario, String email) {
        this.nome = nome;
        this.numeroFuncionario = numeroFuncionario;
        this.email = email;
        this.endereco = null;
        this.listaPublicacoes = new ArrayList<Publicacao>();
    }
    
    @Override
	public String toString() {

		return String.format("[%s] %d Bibliotecário %s cadastrado com sucesso! %s; Publicações: %d", 
				numeroFuncionario,
				id,
				nome,
				endereco,
				listaPublicacoes.size()
			);
	}

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setNumeroFuncionario(String numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Publicacao> getListaPublicacoes() {
        return listaPublicacoes;
    }

    public void setListaPublicacoes(List<Publicacao> listaPublicacoes) {
        this.listaPublicacoes = listaPublicacoes;
    }
}
