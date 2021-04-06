package com.leonardosodre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.leonardosodre.domain.Pessoa;
import com.leonardosodre.repository.PessoaRepository;

public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	

	@GetMapping
	public List<Pessoa> listarTodos(){
		return pessoaRepository.findAll();
	}
	
	
	@PostMapping
	public Pessoa cadastrarPessoa (@RequestBody Pessoa pessoa) {
		Pessoa pessoaCadastrada = pessoaRepository.save(pessoa);
		pessoaCadastrada.setIsVacinada(false);
		return pessoaRepository.save(pessoaCadastrada);
	
	}
	
	@PutMapping("/{codigo}")
	public Pessoa atualizar(@PathVariable("codigo") Long codigo,
			@RequestBody Pessoa pessoa) {
		return pessoaRepository.findById(codigo).map(
				record -> {
					record.setNome(pessoa.getNome());
					record.setCpf(pessoa.getCpf());
					record.setTelefone(pessoa.getTelefone());
					record.setEmail(pessoa.getEmail());
					record.setIdade(pessoa.getIdade());
					record.setDataNascimento(pessoa.getDataNascimento());
					record.setIsVacinada(pessoa.getIsVacinada());
					return pessoaRepository.save(record);
				}).orElse(null);
	
				}

	}
	