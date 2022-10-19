package com.api.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.dto.LivrosDTO;
import com.api.library.service.completeDataListing;

@RestController
@RequestMapping("/v1/api/listall/")
public class ListAllData {
  
	private completeDataListing service;

	public ListAllData(completeDataListing service) {
 		this.service = service;
	}
	
	@GetMapping
	@ResponseBody
	public List<LivrosDTO> listAll(){
		return service.listDataAll();
	}
	
}
