package com.devsuperior.dsvendas.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
	@Autowired
    private SellerRepository repository;
	
	@GetMapping
	public List<SellerDTO> findAll(){
        List<Seller> list = repository.findAll();
        return list.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }

}
