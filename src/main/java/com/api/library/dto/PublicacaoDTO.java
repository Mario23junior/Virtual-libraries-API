package com.api.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PublicacaoDTO {

	private Long id;
	private String coverType;	
 	private String publicationDate;
	private String dimensoes;

	private LivrosDTO livrosDto;
	
	public PublicacaoDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoverType() {
		return coverType;
	}

	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}

	@JsonIgnore
	public LivrosDTO getLivrosDto() {
		return livrosDto;
	}

	public void setLivrosDto(LivrosDTO livrosDto) {
		this.livrosDto = livrosDto;
	}
	
	

}
