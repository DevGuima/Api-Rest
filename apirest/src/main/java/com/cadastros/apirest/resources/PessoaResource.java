package com.cadastros.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import com.cadastros.apirest.models.Pessoa;
import com.cadastros.apirest.repository.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST Pessoas")
@CrossOrigin(origins="*")

public class PessoaResource {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping ("/pessoas")
	@ApiOperation(value = "Retorna uma lista de Pessoas")
	public List<Pessoa> listPessoas(){
		return pessoaRepository.findAll();	
	}
	
	@GetMapping ("/pessoa/{id}")
	@ApiOperation(value = "Retorna uma unica Pessoa")
	public Pessoa listaUnicaPessoa(@PathVariable (value="id") long id){
		return pessoaRepository.findById(id);	
	}
	
	
	@PostMapping("/pessoa")
	@ApiOperation(value = "Salva uma  Pessoa")
	public Pessoa salvaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
		
		
	}
	
	@DeleteMapping("/pessoa")
	@ApiOperation(value = "Deleta uma  Pessoa")
	public void deletaPessoa(@RequestBody Pessoa pessoa) {
		 pessoaRepository.delete(pessoa);
		
		
	}
	
	@PutMapping("/pessoa")
	@ApiOperation(value = "Atualiza uma Pessoa")
	public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
		
		
	}
	
	
	

}
