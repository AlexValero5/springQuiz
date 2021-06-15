package com.example.springQuiz.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springQuiz.daos.ResultadoDao;
import com.example.springQuiz.entidades.Resultado;

@Transactional
@Service
public class ResultadoServicioImpl implements ResultadoServicio{
	
	@Autowired ResultadoDao resultadoDao;

	@Override
	public Resultado crearResultado(Resultado resultado) {
		return resultadoDao.crear(resultado);
	}

	@Override
	public void eliminarResultado(long idResultado) {
		resultadoDao.borrar(idResultado);
		
	}

	@Override
	public Resultado obtenerResultado(long idResultado) {
		return resultadoDao.buscar(idResultado);
	}

	@Override
	public Resultado modificarResultado(Resultado resultado) {
		return resultadoDao.actualizar(resultado);
	}

	@Override
	public List<Resultado> listarResultados() {
		return resultadoDao.listarResultados();
	}

	@Override							//n1                n2                   n3                  n4
	public Integer numeroMayor(Integer gryffindor, Integer ravenclaw, Integer hufflepuff, Integer slytherin) {
		if(gryffindor>ravenclaw) {
			if(gryffindor>hufflepuff){
				if(gryffindor>slytherin)
					return gryffindor;
				else
					return slytherin;
			}else
				if(hufflepuff>slytherin) 
					return hufflepuff;
				else 
					return slytherin;
				
				
		}else 
			if(ravenclaw>hufflepuff)
				if(ravenclaw>slytherin)
					return ravenclaw;
				else
					return slytherin;
			else
				if(hufflepuff>slytherin)
					return hufflepuff;
				else 
					return slytherin;
	}

//	@Override
//	public Integer numeroMayor(Integer [] numeros) {
//		Integer nMayor=0;
//		
//		for(int i=0; i<=numeros.length-1; i++) {
//			if(i==0)
//				nMayor=numeros[0];
//			if(numeros[i]>nMayor)
//				nMayor=numeros[i];
//		}
//		return nMayor;
//	}
	
	

}
