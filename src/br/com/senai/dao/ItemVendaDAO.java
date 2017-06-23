package br.com.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senai.model.ItemVenda;

public class ItemVendaDAO {

	public void salvar(ItemVenda itemVenda) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(itemVenda);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<ItemVenda> listarItensVenda() {
		// ItemVenda itemPedido
		// System.out.println("Chegou na ItemVendaDao! E o valor de do pedido é:
		// "+itemPedido.getPedidoVenda().getId());
		// Query query = entityManager.createQuery("from PedidoVenda where
		// id="+itemPedido.getPedidoVenda().getId()+" Order By id");

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from ItemVenda  Order By id");

		return query.getResultList();
	}

	public void excluir(ItemVenda itemVenda) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		itemVenda = entityManager.merge(itemVenda);

		entityManager.remove(itemVenda);

		entityManager.getTransaction().commit();

		entityManager.close();

	}
}
