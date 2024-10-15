package br.edu.infnet.caio.sampaio.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario {
    private String nome;
    private String numeroFuncionario;
    private String email;
    private Endereco endereco;
    private List<Publicacao> listaPublicacoes;

    @Override
    public String toString() {
    	return String.format("[%s] Vendedor %s cadastrado com sucesso! Publicações: %d",
    			numeroFuncionario,
    			nome,
    			listaPublicacoes.size()
    			);
    }
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

    // Getters e Setters
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
