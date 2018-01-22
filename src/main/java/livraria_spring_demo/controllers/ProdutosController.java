package livraria_spring_demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import livraria_spring_demo.daos.ProdutoDAO;
import livraria_spring_demo.models.Produto;
import livraria_spring_demo.models.TipoPreco;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		
		
		return modelAndView;
	}
	
	@RequestMapping( method=RequestMethod.POST)
	public ModelAndView grava(@Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		System.out.println(produto.toString());
		
		if(bindingResult.hasErrors()) {
			System.out.println("erro");
			return form();
		} else {
			
			produtoDAO.gravar(produto);
			redirectAttributes.addFlashAttribute("sucesso", "Prosuto Cadastrado com sucesso");
			ModelAndView modelAndView = new ModelAndView("redirect:produtos");
			
			return modelAndView;
		}
		
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {		
		List<Produto> produtos = produtoDAO.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos",produtos);
		return modelAndView;
	}
	
	
	
}
