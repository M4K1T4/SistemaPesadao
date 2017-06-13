package br.com.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senai.model.PedidoCompra;

public class PedidoCompraDAO {

	public void salvar(PedidoCompra pedidocompra) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(pedidocompra);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	@SuppressWarnings("unchecked")
	public List<PedidoCompra> listarPedidoCompras() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from PedidoCompra Order By pec_id");

		return query.getResultList();
	}

	public void excluir(PedidoCompra pedidocompra) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		pedidocompra = entityManager.merge(pedidocompra);
		
		entityManager.remove(pedidocompra);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
