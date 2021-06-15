package com.example.springQuiz.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springQuiz.entidades.Resultado;
import com.example.springQuiz.servicios.ResultadoServicio;

@Controller
public class ResultadosController {
	
	@Autowired ResultadoServicio resultadoServicio;
	
	@RequestMapping(method = RequestMethod.GET, value = "/resultados")
	public ModelAndView comprobarResult(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		
		HttpSession s =request.getSession();
		
		String nombre=(String) s.getAttribute("nombreUser");
		
		Integer contGrif=(Integer) s.getAttribute("gryffindor");
		Integer contSly=(Integer) s.getAttribute("slytherin");
		Integer contHuf=(Integer) s.getAttribute("hufflepuff");
		Integer contRav=(Integer) s.getAttribute("ravenclaw");
		String resultado;
		if(contGrif>contRav) {
			if(contGrif>contHuf){
				if(contGrif>contSly)
					resultado= "Gryffindor";
				else
					resultado= "Slytherin";
			}else
				if(contHuf>contSly) 
					resultado= "Hufflepuff";
				else 
					resultado= "Slytherin";
				
				
		}else 
			if(contRav>contHuf)
				if(contRav>contSly)
					resultado= "Ravenclaw";
				else
					resultado= "Slytherin";
			else
				if(contHuf>contSly)
					resultado= "Hufflepuff";
				else 
					resultado= "Slytherin";
	
		Resultado r=new Resultado(nombre,resultado);
		
		resultadoServicio.crearResultado(r);
		mav.addObject("result",r);
		mav.setViewName("/resultados/resultado");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/inicio")
	public String volverJugar(HttpServletRequest request) {
		
		HttpSession s =request.getSession();
		
		String nombre=(String) s.getAttribute("nombreUser");
		
		Integer contGrif=(Integer) s.getAttribute("gryffindor");
		Integer contSly=(Integer) s.getAttribute("slytherin");
		Integer contHuf=(Integer) s.getAttribute("hufflepuff");
		Integer contRav=(Integer) s.getAttribute("ravenclaw");
		
		nombre="";
		contGrif=0;
		contHuf=0;
		contRav=0;
		contSly=0;
		
		s.setAttribute("gryffindor", contGrif);
		s.setAttribute("slytherin", contSly);
		s.setAttribute("hufflepuff", contHuf);
		s.setAttribute("ravenclaw", contRav);
		s.setAttribute("nombreUser", nombre);
		
		return "index";
		
		
		
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/resultados/ultimosResultados")
	public ModelAndView mostrar5Ultimos(HttpServletRequest request) {
		
		ModelAndView mav=new ModelAndView();
		
		List<Resultado> resultados=resultadoServicio.listarResultados();
		
		mav.addObject("resultados",resultados);
		mav.setViewName("/resultados/totales");
		
		return mav;
	}

}
