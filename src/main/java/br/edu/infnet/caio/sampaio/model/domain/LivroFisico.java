package br.edu.infnet.caio.sampaio.model.domain;

public class LivroFisico extends Publicacao {
    private double peso;
    private int quantidadeEstoque;

    // Construtor
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
