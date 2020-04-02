package com.cadastros.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import com.cadastros.apirest.models.Pessoa;
import com.cadastros.apirest.repository.PessoaRepository;

@RestController
@RequestMapping(value="/api")

public class PessoaResource {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping ("/pessoas")
	public List<Pessoa> listPessoas(){
		return pessoaRepository.findAll();	
	}
	
	@GetMapping ("/pessoa/{id}")
	public Pessoa listaUnicaPessoa(@PathVariable (value="id") long id){
		return pessoaRepository.findById(id);	
	}
	
	
	@PostMapping("/pessoa")
	public Pessoa salvaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
		
		
	}
	
	
	
	

}
