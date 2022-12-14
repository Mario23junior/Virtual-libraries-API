package com.api.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PropriedadesDTO {

	private Long id;
	private Integer page;
	private Long isbn;
	private String theme;
	 
	private LivrosDTO livrosDto;
    
	
	@JsonIgnore
	public LivrosDTO getLivrosDto() {
		return livrosDto;
	}

	public void setLivrosDto(LivrosDTO livrosDto) {
		this.livrosDto = livrosDto;
	}

	public PropriedadesDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	
 

}
