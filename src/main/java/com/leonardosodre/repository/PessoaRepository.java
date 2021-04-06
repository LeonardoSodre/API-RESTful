package com.leonardosodre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardosodre.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
