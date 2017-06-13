package br.com.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senai.model.PedidoVenda;

public class PedidoVendaDAO {
	
	public void salvar(PedidoVenda pedidoVenda) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(pedidoVenda);

		entityManager.getTransaction().commit();

		entityManager.close();

	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoVenda> listarPedidosVendas() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from PedidoVenda Order By id");

		return query.getResultList();
	}
	
	public void excluir(PedidoVenda pedidoVenda) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		pedidoVenda = entityManager.merge(pedidoVenda);
		
		entityManager.remove(pedidoVenda);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
	
}
