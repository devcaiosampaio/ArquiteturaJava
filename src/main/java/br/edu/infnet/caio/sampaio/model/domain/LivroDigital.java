package br.edu.infnet.caio.sampaio.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_livrodigital")
public class LivroDigital extends Publicacao {
    private String formatoArquivo;
    private double tamanhoArquivo;
    
    public LivroDigital(){}
    public LivroDigital(String titulo, String autor, String editora, String formatoArquivo, double tamanhoArquivo) {
        super(titulo, autor, editora);
        this.formatoArquivo = formatoArquivo;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    // Getters e Setters
    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }
}

