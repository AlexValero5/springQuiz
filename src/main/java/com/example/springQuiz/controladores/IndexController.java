package com.example.springQuiz.controladores;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class IndexController {
	
	
	
	@GetMapping({ "/", "index" })
	public String index() {
		return "index";

	}
	
	
	@RequestMapping(method= RequestMethod.POST, value = "/comenzarQuiz")
	public String comenzar(HttpServletRequest request) {
		HttpSession s=request.getSession();
		
		String nombre=request.getParameter("nombreUsuario");
		
		s.setAttribute("nombreUser", nombre);
		
		return "/preguntas/pregunta";
	}

}
