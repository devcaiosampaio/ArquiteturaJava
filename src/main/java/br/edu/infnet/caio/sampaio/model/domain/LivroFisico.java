package br.edu.infnet.caio.sampaio.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_livrofisico")
public class LivroFisico extends Publicacao {	
    private double peso;
    private int quantidadeEstoque;

    // Construtor
    public LivroFisico(){}
    public LivroFisico(String titulo, String autor, String editora, double peso, int quantidadeEstoque) {
        super(titulo, autor, editora);
       
        this.peso = peso;        
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getters e Setters
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
