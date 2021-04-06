package com.leonardosodre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardosodre.domain.GrupoPrioridades;
import com.leonardosodre.repository.GrupoPrioridadeRepository;


@RestController
@RequestMapping("/grupos-prioridades")
public class GrupoPrioridadesController {


	@Autowired
	private GrupoPrioridadeRepository grupoPrioridadesRepository;
	
	@GetMapping
	public List<GrupoPrioridades> listarTodos(){
		return grupoPrioridadesRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public GrupoPrioridades buscarPeloCodigo(@PathVariable Long codigo) {
		return grupoPrioridadesRepository.findById(codigo).orElse(null);
	}
	
}


