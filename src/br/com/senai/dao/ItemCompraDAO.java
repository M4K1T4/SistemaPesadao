package br.com.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senai.model.ItemCompra;

public class ItemCompraDAO {

	public void salvar(ItemCompra itemcompra) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(itemcompra);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	@SuppressWarnings("unchecked")
	public List<ItemCompra> listarItemCompras() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from ItemCompra Order By itc_valorCompra");

		return query.getResultList();
	}

	public void excluir(ItemCompra itemcompra) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		itemcompra = entityManager.merge(itemcompra);
		
		entityManager.remove(itemcompra);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
	
    
}
