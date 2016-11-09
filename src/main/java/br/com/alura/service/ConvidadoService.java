package br.com.alura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	public Iterable<Convidado> obterTodos() {
	
		Iterable<Convidado> convidados = convidadoRepository.findAll();
		
		return convidados;
	}
	
	public Convidado obterUmConvidado(long id) {
		Convidado convidados = convidadoRepository.findOne(id);
		
		return convidados;
	}
	
	public void salvar(Convidado novoConvidado) {
		convidadoRepository.save(novoConvidado);
	}
	
	public void remover(Convidado convidado) {
		convidadoRepository.delete(convidado);
	}
}
