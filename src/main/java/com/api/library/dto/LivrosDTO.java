package com.api.library.dto;

import java.util.List;

public class LivrosDTO {

	private Long id;
	private String image;
	private String name;
	private String author;
	private Integer edition;
	private String publishingCompany;
	
	private List<PropriedadesDTO> propriedadesDto;
	private List<PublicacaoDTO> publicacaoDto;

	public LivrosDTO() {
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

	public List<PropriedadesDTO> getPropriedadesDto() {
		return propriedadesDto;
	}

	public void setPropriedadesDto(List<PropriedadesDTO> propriedadesDto) {
		this.propriedadesDto = propriedadesDto;
	}

	public List<PublicacaoDTO> getPublicacaoDto() {
		return publicacaoDto;
	}

	public void setPublicacaoDto(List<PublicacaoDTO> publicacaoDto) {
		this.publicacaoDto = publicacaoDto;
	}
	
	

}
