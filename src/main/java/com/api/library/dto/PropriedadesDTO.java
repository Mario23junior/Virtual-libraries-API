package com.api.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PropriedadesDTO {

	private Long id;
	private Integer page;
	private Long isbn;
	private String theme;

	private LivrosDTO livrosDTO;

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

	@JsonIgnore
	public LivrosDTO getLivrosDTO() {
		return livrosDTO;
	}

	public void setLivrosDTO(LivrosDTO livrosDTO) {
		this.livrosDTO = livrosDTO;
	}

}
