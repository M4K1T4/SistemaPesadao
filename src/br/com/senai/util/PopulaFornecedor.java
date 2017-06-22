package br.com.senai.util;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.senai.dao.JPAUtil;
import br.com.senai.model.Estado;
import br.com.senai.model.Fornecedor;

public class PopulaFornecedor {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Fornecedor fornecedor1 = new Fornecedor("RoupasAWX118", "AEX118 ", "46.949.322/0001-82", 
				new Date(), "Rua Lavínia", "Vila Alexandria", "São Paulo", "2°andar", 
				"(17) 2941-4243", "(17) 99423-9730", "989.987.660.392", "989.987.660.392", new Date(), Estado.SP, "AWX118@gmail.com.br");
		
		Fornecedor fornecedor2 = new Fornecedor("Atacado Barato", "Barato ", "57.752.548/0001-05", 
				new Date(), "Rua Araponga", "Jardim Dom Bosco", "São Paulo", "1°andar", 
				"(19) 3975-4451", "(19) 98181-6060", "559.400.082.920", "559.400.082.920", new Date(), Estado.SP, "Barato@hotmail.com");

		Fornecedor fornecedor3 = new Fornecedor("Moda do Corpo", "Moda ", "45.101.956/0001-18", 
				new Date(), "Rua Antônio Augusto", "Ernani de Moura Lima", "Londrina", "14°andar", 
				"(43) 2528-9418", "(43) 98973-8025", "610.24756-30", "610.24756-30", new Date(), Estado.PR, "Moda@gmail.com");

		Fornecedor fornecedor4 = new Fornecedor("Roupas Chinabúye", "Chinabúye ", "35.193.225/0001-96", 
				new Date(), "Avenida Vice-Prefeito Reginaldo Guedes Nocera", "Centro", "Telêmaco Borba", "29°andar", 
				"(42) 2554-7323", "(42) 98684-5268", "887.26846-04", "887.26846-04", new Date(), Estado.PR, "Chinabúye@gmail.com.br");

		Fornecedor fornecedor5 = new Fornecedor("Roupas Beijo Roubado", "Beijo Roubado ", "47.707.552/0001-06", 
				new Date(), "Rua Felipe Baczinski", "Centro", "Tigrinhos", "6°andar", 
				"(49) 2541-6460", "(49) 98189-1657", "503.766.119", "503.766.119", new Date(), Estado.SC, "BeijoRoubado@outlook.com");

		em.persist(fornecedor1);
		em.persist(fornecedor2);
 		em.persist(fornecedor3);
		em.persist(fornecedor4);
		em.persist(fornecedor5);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
