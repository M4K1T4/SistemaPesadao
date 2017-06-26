package br.com.senai.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.senai.model.Cliente;

/**
 * @author Equipe 1 (Leonardo André, Luan Magalhães, Matheus Garcia, Vinicius
 *         Andrade)
 */
public class ClienteDao {
	/**
	 * 
	 * @param cliente
	 *            Método para salvar ciente, enviando informaçoes ao banco de
	 *            dados.
	 */
	public void salvar(Cliente cliente) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * Método para listar informações do cliente, buscando informações do banco
	 * de dados.
	 */
	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		Query query = entityManager.createQuery("from Cliente Order By nomeCli");
		return query.getResultList();
	}

	/**
	 * @param cliente
	 *
	 */
	public void excluir(Cliente cliente) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		cliente = entityManager.merge(cliente);
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * @param id
	 *            Método para retornar o id do cliente requerido.
	 */
	public Cliente porId(Integer id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		return entityManager.find(Cliente.class, id);
	}
}