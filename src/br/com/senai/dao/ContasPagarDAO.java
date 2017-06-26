package br.com.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senai.model.ContasPagar;

public class ContasPagarDAO {

	public void salvar(ContasPagar contasPagar) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(contasPagar);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	@SuppressWarnings("unchecked")
	public List<ContasPagar> listarContas() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from ContasPagar");

		return query.getResultList();
	}
	
	public void excluir(ContasPagar contasPagar) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		contasPagar = entityManager.merge(contasPagar);

		entityManager.remove(contasPagar);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

}
