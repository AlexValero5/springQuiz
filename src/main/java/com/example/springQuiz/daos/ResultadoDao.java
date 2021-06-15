package com.example.springQuiz.daos;

import java.util.List;

import com.example.springQuiz.entidades.Resultado;

public interface ResultadoDao extends DaoGenerico<Resultado>{
	
	public List<Resultado> listarResultados();

}
