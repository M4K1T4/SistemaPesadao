package br.com.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senai.model.Estoque;

public class EstoqueDAO {

	@SuppressWarnings("unchecked")
	public List<Estoque> listarEstoque() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from estoque");

		return query.getResultList();
	}

}
