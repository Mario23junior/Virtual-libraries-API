package com.api.library.carga;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.library.dto.LivrosDTO;
import com.api.library.dto.PropriedadesDTO;
import com.api.library.dto.PublicacaoDTO;
import com.api.library.model.Livros;
import com.api.library.repository.LivrosRepository;

@Service
public class carga {
  
	@Autowired
	private LivrosRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	public void dateBasePower() {
		
		LivrosDTO l1 = new LivrosDTO();
		l1.setId(1l);
		
	
		PublicacaoDTO publiId = new PublicacaoDTO();
		publiId.setId(2l);
		
		
		PropriedadesDTO p1 = new PropriedadesDTO();
 		p1.setPage(968);
		p1.setIsbn(8543004799l);
		p1.setTheme("Computação");
		p1.setLivrosDto(l1);
		
		PublicacaoDTO publi = new PublicacaoDTO();
		publi.setCoverType("Capa comun");
		publi.setPublicationDate("24/06/2016");
		publi.setDimensoes("28 x 20.8 x 3.8cm");
		publi.setLivrosDto(l1);
		
		LivrosDTO livros1 = new LivrosDTO();
		livros1.setName("Java®: Como Programar");
		livros1.setImage("https://m.media-amazon.com/images/I/81jdJ94mSbL.jpg");
		livros1.setAuthor("Paul Deitel, Harvey Deite");
		livros1.setEdition(10);
		livros1.setPublishingCompany("Pearson Universidades");
		livros1.setPropriedadesDto(Arrays.asList(p1));
		livros1.setPublicacaoDto(Arrays.asList(publi));
		
		LivrosDTO ldto = mapper.map(livros1, LivrosDTO.class);
		repository.saveAll(Arrays.asList(mapper.map(ldto, Livros.class)));
	}
	
	
}
