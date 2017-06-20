package br.com.senai.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estoque implements Serializable {

	private static final long serialVersionUID = -7075401812346930278L;

	private Integer id;
	private Produto idProdutoEstoque;
	private String nomeProdutoEstoque;
	private int quantidadeEstoque;
	private Date lastUpdate;
	private double totalEstoque;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "est_produto", nullable = false)
	public Produto getIdProdutoEstoque() {
		return idProdutoEstoque;
	}

	public void setIdProdutoEstoque(Produto idProdutoEstoque) {
		this.idProdutoEstoque = idProdutoEstoque;
	}

	@Column(name = "est_descricao", length = 120, nullable = false)
	public String getNomeProdutoEstoque() {
		return nomeProdutoEstoque;
	}

	public void setNomeProdutoEstoque(String nomeProdutoEstoque) {
		this.nomeProdutoEstoque = nomeProdutoEstoque;
	}

	@Column(name = "est_qtde", columnDefinition = "int default 0")
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	@Column(name = "est_lastUpdate")
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@Column(name = "est_valorTotal", columnDefinition = "DOUBLE default 0")
	public double getTotalEstoque() {
		return totalEstoque;
	}

	public void setTotalEstoque(double totalEstoque) {
		this.totalEstoque = totalEstoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", idProdutoEstoque=" + idProdutoEstoque + ", nomeProdutoEstoque="
				+ nomeProdutoEstoque + ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}

}
