package com.example.springQuiz.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.example.springQuiz.entidades.Resultado;

@Repository
@Component("ResultadoDao")
public class ResultadoDaoImpl extends DaoGenericoImpl<Resultado> implements ResultadoDao{

	@Override
	public List<Resultado> listarResultados() {
		Query query = this.em.createQuery(" FROM  Resultado ").setFirstResult(0).setMaxResults(5);
		List<Resultado> lResultado = query.getResultList();

		if (lResultado != null) {
			return lResultado;
		}
		return null;
	}

}
