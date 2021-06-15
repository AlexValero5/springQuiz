package com.example.springQuiz.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/preguntas")
public class PreguntaController {
	
	@RequestMapping(method= RequestMethod.POST, value = "/primeraPregunta")
	public String pregunta1(HttpServletRequest request) {
		
		Integer mesNacimiento=Integer.parseInt(request.getParameter("mesNacimiento"));
		
		Integer anioNacimiento=Integer.parseInt(request.getParameter("anioNacimiento"));
		
		HttpSession s=request.getSession();
		
		Integer mesResultado=mesNacimiento%2;
		
		Integer anioResultado=anioNacimiento%2;
		
		Integer contadorSlytherin=0;
		Integer contadorGryffindor=0;
		Integer contadorHufflepuff=0;
		Integer contadorRavenclaw=0;
		
		
		//Si mes es impar
		if(mesResultado!=0) {
			//Si año es impar
			if(anioResultado!=0)
				contadorRavenclaw++;
			else
				contadorSlytherin++;
		}else {
			if(anioResultado!=0)
				contadorGryffindor++;
			else
				contadorHufflepuff++;
		}
		
		s.setAttribute("slytherin", contadorSlytherin);
		s.setAttribute("ravenclaw", contadorRavenclaw);
		s.setAttribute("gryffindor", contadorGryffindor);
		s.setAttribute("hufflepuff", contadorHufflepuff);
		
		
		return "/preguntas/pregunta2";
	}

	
	
	@RequestMapping(method= RequestMethod.POST, value = "/segundaPregunta")
	public String pregunta2(HttpServletRequest request, @RequestParam(required = false, name = "valor") String valor,@RequestParam(required=false,name="fuerza") String fuerza,
			@RequestParam(required=false, name="justicia") String justicia,@RequestParam(required=false, name="lealtad") String lealtad,@RequestParam(required=false, name="creatividad") String creatividad,
			@RequestParam(required=false, name="erudiccion") String erudiccion,@RequestParam(required=false, name="ambicion") String ambicion,@RequestParam(required=false, name="determinacion") String determinacion) {
		
		
		HttpSession s=request.getSession();
		Integer grif=(Integer) s.getAttribute("gryffindor");
		Integer sly=(Integer) s.getAttribute("slytherin");
		Integer huf=(Integer) s.getAttribute("hufflepuff");
		Integer rav=(Integer) s.getAttribute("ravenclaw");
		
		
		
		
		if(valor!=null)
			grif++;
		if(fuerza!=null)
			grif++;
		if(justicia!=null)
			huf++;
		if(lealtad!=null)
			huf++;
		if(creatividad!=null)
			rav++;
		if(erudiccion!=null)
			rav++;
		if(ambicion!=null)
			sly++;
		if(determinacion!=null)
			sly++;
		
		s.setAttribute("slytherin", sly);
		s.setAttribute("ravenclaw", rav);
		s.setAttribute("gryffindor", grif);
		s.setAttribute("hufflepuff", huf);
			
		
		return "/preguntas/pregunta3";
	}
	
	@RequestMapping(method= RequestMethod.POST, value = "/terceraPregunta")
	public String pregunta3(HttpServletRequest request) {
		HttpSession s=request.getSession();
		
		Integer escogida=Integer.parseInt(request.getParameter("pregunta"));
		
		Integer contGrif=(Integer) s.getAttribute("gryffindor");
		Integer contSly=(Integer) s.getAttribute("slytherin");
		Integer contHuf=(Integer) s.getAttribute("hufflepuff");
		Integer contRav=(Integer) s.getAttribute("ravenclaw");
		
		
		
		if(escogida==1)
			contGrif++;
		if(escogida==2)
			contHuf++;
		if(escogida==3)
			contRav++;
		if(escogida==4)
			contSly++;
		
		s.setAttribute("slytherin", contSly);
		s.setAttribute("ravenclaw", contRav);
		s.setAttribute("gryffindor", contGrif);
		s.setAttribute("hufflepuff", contHuf);
		
		return "/preguntas/pregunta4";
	}
	
	@RequestMapping(method= RequestMethod.POST, value = "/cuartaPregunta")
	public String pregunta4(HttpServletRequest request) {
		
		Integer escogido=Integer.parseInt(request.getParameter("profesor"));
		
		HttpSession s=request.getSession();
		
		Integer contGrif=(Integer) s.getAttribute("gryffindor");
		Integer contSly=(Integer) s.getAttribute("slytherin");
		Integer contHuf=(Integer) s.getAttribute("hufflepuff");
		Integer contRav=(Integer) s.getAttribute("ravenclaw");
		
		if(escogido==1)
			contGrif++;
		if(escogido==2)
			contRav++;
		if(escogido==3)
			contHuf++;
		if(escogido==4)
			contSly++;
		
		s.setAttribute("slytherin", contSly);
		s.setAttribute("ravenclaw", contRav);
		s.setAttribute("gryffindor", contGrif);
		s.setAttribute("hufflepuff", contHuf);
		
		
		
		return "/preguntas/pregunta5";
	}
	
	@RequestMapping(method= RequestMethod.POST, value = "/quintaPregunta")
	public String pregunta5(HttpServletRequest request) {
		
	Integer escogido=Integer.parseInt(request.getParameter("animal"));
		
	HttpSession s=request.getSession();
	
	Integer contGrif=(Integer) s.getAttribute("gryffindor");
	Integer contSly=(Integer) s.getAttribute("slytherin");
	Integer contHuf=(Integer) s.getAttribute("hufflepuff");
	Integer contRav=(Integer) s.getAttribute("ravenclaw");
	
	if(escogido==1)
		contGrif++;
	if(escogido==2)
		contRav++;
	if(escogido==3)
		contHuf++;
	if(escogido==4)
		contSly++;
	
	s.setAttribute("slytherin", contSly);
	s.setAttribute("ravenclaw", contRav);
	s.setAttribute("gryffindor", contGrif);
	s.setAttribute("hufflepuff", contHuf);
	
	
		
		return "/preguntas/pregunta6";
	}
	
	@RequestMapping(method= RequestMethod.POST, value = "/sextaPregunta")
	public String pregunta6(HttpServletRequest request,@RequestParam(name="nombre")String nombrePersonaje) {
		
		HttpSession s =request.getSession();
		
		Integer contGrif=(Integer) s.getAttribute("gryffindor");
		Integer contSly=(Integer) s.getAttribute("slytherin");
		Integer contHuf=(Integer) s.getAttribute("hufflepuff");
		Integer contRav=(Integer) s.getAttribute("ravenclaw");
		
		String minusculas=nombrePersonaje.toLowerCase();
		
		if(minusculas=="ron")
			contGrif++;
		if(minusculas=="cedric")
			contHuf++;
		if(minusculas=="padma")
			contRav++;
		if(minusculas=="draco")
			contSly++;
		
		s.setAttribute("slytherin", contSly);
		s.setAttribute("ravenclaw", contRav);
		s.setAttribute("gryffindor", contGrif);
		s.setAttribute("hufflepuff", contHuf);
		
		
		
		return "/preguntas/pregunta7";
	}
	
	@RequestMapping(method= RequestMethod.POST, value = "/septimaPregunta")
	public String pregunta7(HttpServletRequest request) {
		
		HttpSession s =request.getSession();
		
		Integer contGrif=(Integer) s.getAttribute("gryffindor");
		Integer contSly=(Integer) s.getAttribute("slytherin");
		Integer contHuf=(Integer) s.getAttribute("hufflepuff");
		Integer contRav=(Integer) s.getAttribute("ravenclaw");
		
		Integer resultado=Integer.parseInt(request.getParameter("pregunta"));
		
		if(resultado==1)
			contGrif++;
		if(resultado==2)
			contHuf++;
		if(resultado==3)
			contRav++;
		if(resultado==4)
			contSly++;
		
		s.setAttribute("slytherin", contSly);
		s.setAttribute("ravenclaw", contRav);
		s.setAttribute("gryffindor", contGrif);
		s.setAttribute("hufflepuff", contHuf);
		
		
		
		
		
		
		return "finalizado";
	}
	
	
}
