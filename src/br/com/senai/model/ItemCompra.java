package br.com.senai.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ItemCompra implements Serializable {

	private static final long serialVersionUID = -8772208579953977751L;

	private Integer id;
	private Integer produtoCompra;
	private Integer pedidoCompra;
	private String qntCompra;
	private double valorCompra;
	private Date cadastroCompra = new Date();
	private boolean activeCompra = true;

	@Id
	@Column(name = "itc_id", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "itc_pro_id", length = 50)
	public Integer getProdutoCompra() {
		return produtoCompra;
	}

	public void setProdutoCompra(Integer produtoCompra) {
		this.produtoCompra = produtoCompra;
	}

	@Column(name = "itc_ped_id", length = 50)
	public Integer getPedidoCompra() {
		return pedidoCompra;
	}

	public void setPedidoCompra(Integer pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	@Column(name = "itc_quantidade", length = 50)
	public String getQntCompra() {
		return qntCompra;

	}

	public void setQntCompra(String qntCompra) {
		this.qntCompra = qntCompra;
	}

	@Column(name = "itc_valorCompra", length = 50)
	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	@Column(name = "itc_cadastroCompra", length = 50)
	@Temporal(TemporalType.DATE)
	public Date getCadastroCompra() {
		return cadastroCompra;
	}

	public void setCadastroCompra(Date cadastroCompra) {
		this.cadastroCompra = cadastroCompra;
	}

	@Column(name = "itc_status", length = 50)
	public boolean isActiveCompra() {
		return activeCompra;
	}

	public void setActiveCompra(boolean activeCompra) {
		this.activeCompra = activeCompra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItemCompra other = (ItemCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemCompra [id=" + id + ", produtoCompra=" + produtoCompra + ", pedidoCompra=" + pedidoCompra
				+ ", qntCompra=" + qntCompra + ", valorCompra=" + valorCompra + ", cadastroCompra=" + cadastroCompra
				+ ", activeCompra=" + activeCompra + "]";
	}
}
