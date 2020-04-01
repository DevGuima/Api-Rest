package com.cadastros.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastros.apirest.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	
	Pessoa findById(long id);
	

}
