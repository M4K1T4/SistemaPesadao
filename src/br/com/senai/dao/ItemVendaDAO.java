package br.com.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senai.model.ItemVenda;
import br.com.senai.model.PedidoVenda;

public class ItemVendaDAO {

	public void salvar(ItemVenda itemVenda) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(itemVenda);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<ItemVenda> listarItensVenda(ItemVenda itemPedido) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		Query query = entityManager.createQuery("from ItemVenda where pedidoVenda="+itemPedido.getPedidoVenda()+"  Order By id");
		
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
