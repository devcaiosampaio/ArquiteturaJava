package br.edu.infnet.caio.sampaio.model.domain;

public class Endereco {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    
    public Endereco(String cep) {
    	 this.rua = "";
         this.numero = "";
         this.cidade = "";
         this.estado = "";
         this.cep = cep;
	}
	// Getters e Setters
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}

