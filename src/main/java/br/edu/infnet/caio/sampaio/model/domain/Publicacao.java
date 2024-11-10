package br.edu.infnet.caio.sampaio.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_publicacao")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publicacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 	
	private String descricao;

	@NotBlank(message = "O titulo da publicação é obrigatória.")
	@Size(max = 50, message = "O titulo deve ter no máximo 50 caracteres.")	
    private String titulo;
    private String autor;
    private String editora;

    @ManyToOne
	@JoinColumn(name = "idBibliotecario")
	@JsonBackReference
	private Bibliotecario bibliotecario;
    
    @Override 
    public String toString() {
    	return String.format("%s - %s - %s - %s", 
				descricao,
				titulo,
				autor,
				editora
			);
    }
    
    public Publicacao() {
    }
    public Publicacao(String titulo, String autor, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
}

