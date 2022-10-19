package com.api.library.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livros {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String image;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String author;

	private Integer edition;

	@Column(nullable = false)
	private String publishingCompany;

	@OneToMany(mappedBy = "livros", cascade = CascadeType.ALL)
	private List<Propriedades> propriedades;

	@OneToMany(mappedBy = "livros", cascade = CascadeType.ALL)
	private List<Publicacao> publicacao;

	public Livros() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	@JsonIgnore
	public List<Propriedades> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<Propriedades> propriedades) {
		this.propriedades = propriedades;
	}

	@JsonIgnore
	public List<Publicacao> getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(List<Publicacao> publicacao) {
		this.publicacao = publicacao;
	}

}
