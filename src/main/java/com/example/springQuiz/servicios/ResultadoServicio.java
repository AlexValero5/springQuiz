package com.example.springQuiz.servicios;

import java.util.List;

import com.example.springQuiz.entidades.Resultado;



public interface ResultadoServicio {
	public Resultado crearResultado(Resultado resultado);

	public void eliminarResultado(long idResultado);

	public Resultado obtenerResultado(long idResultado);

	public Resultado modificarResultado(Resultado resultado);

	public List<Resultado> listarResultados();
	
	//public Integer numeroMayor(Integer[] numeros);
	
	public Integer numeroMayor(Integer n1,Integer n2,Integer n3,Integer n4);

	

}
