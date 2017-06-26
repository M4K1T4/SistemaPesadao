package br.com.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senai.model.Fornecedor;

public class FornecedorDAO {

	public void salvar(Fornecedor fornecedor) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(fornecedor);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarFornecedores() {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		Query query = entityManager.createQuery("from Fornecedor Order By nomeFornecedor");
		
		return query.getResultList();
	}

	public void excluir(Fornecedor fornecedor) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		fornecedor = entityManager.merge(fornecedor);

		entityManager.remove(fornecedor);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

}