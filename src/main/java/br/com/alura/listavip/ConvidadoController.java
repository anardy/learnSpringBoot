package br.com.alura.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {

		model.addAttribute("convidados", service.obterTodos());

		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("telefone") String telefone,
			@RequestParam("email") String email, Model model) {
		Convidado novoConvidado = new Convidado(nome, email, telefone);
		
		service.salvar(novoConvidado);

		model.addAttribute("convidados", service.obterTodos());

		return "listaconvidados";
	}

	@RequestMapping(value = "remover", method = RequestMethod.DELETE)
	public String remover(@RequestParam("id") long id, Model model) {

		Convidado convidadoRemovido = service.obterUmConvidado(id);
		
		service.remover(convidadoRemovido);

		model.addAttribute("convidados", service.obterTodos());

		return "listaconvidados";
	}
}
