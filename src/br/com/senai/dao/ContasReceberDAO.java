package br.com.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senai.model.ContasReceber;

public class ContasReceberDAO {

	public void salvar(ContasReceber contasReceber){
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(contasReceber);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContasReceber> listarContas(){
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		Query query = entityManager.createQuery("from ContasReceber Order By id");
		return query.getResultList();
	}
	
}
