package com.api.library.model;

public class Livros {

	private Long id;
	private String image;
	private String name;
	private String author;
	private Integer edition;
	private String PublishingCompany;
	
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
		return PublishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		PublishingCompany = publishingCompany;
	}

}
