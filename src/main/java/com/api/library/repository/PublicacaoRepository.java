package com.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.library.model.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {

	Publicacao findByCoverType(String coverType);

}
