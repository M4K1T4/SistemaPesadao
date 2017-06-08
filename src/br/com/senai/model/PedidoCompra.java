package br.com.senai.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class PedidoCompra implements Serializable {

	private static final long serialVersionUID = 5423565912715065539L;
	private Integer id;
	private Fornecedor fornecedorPedido;
	private String parcelaPedido;
	private Date cadastroProduto;
	private boolean activePedido = true;

	@Id
	@Column(name = "pec_id", length = 50)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "pec_for_id", length = 50)
	public Fornecedor getFornecedor() {
		return fornecedorPedido;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedorPedido = fornecedor;
	}

	@Column(name = "pec_parcelaPedido", length = 50)
	public String getParcelaPedido() {
		return parcelaPedido;
	}

	public void setParcelaPedido(String parcelaPedido) {
		this.parcelaPedido = parcelaPedido;
	}

	@Column(name = "pec_cadastroPedido", length = 50)
	public Date getCadastroProduto() {
		return cadastroProduto;

	}

	public void setCadastroProduto(Date cadastroProduto) {
		this.cadastroProduto = cadastroProduto;
	}

	public Fornecedor getFornecedorPedido() {
		return fornecedorPedido;
	}

	public void setFornecedorPedido(Fornecedor fornecedorPedido) {
		this.fornecedorPedido = fornecedorPedido;

	}

	public boolean isActivePedido() {
		return activePedido;

	}

	public void setActivePedido(boolean activePedido) {
		this.activePedido = activePedido;
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
		PedidoCompra other = (PedidoCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PedidoCompra [id=" + id + ", fornecedorPedido=" + fornecedorPedido + ", parcelaPedido=" + parcelaPedido
				+ ", cadastroProduto=" + cadastroProduto + ", activePedido=" + activePedido + "]";
	}

}
