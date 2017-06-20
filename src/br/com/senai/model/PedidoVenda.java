// @Author: Equipe 1;
// model de Pedido Venda que irá abastecer a tabela contas a receber.
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
public class PedidoVenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3464452938793991975L;

	private Integer id;
	private Cliente cliente;
	private Date dataVenda = new Date();
	private int formapagamento = 1;

	@Id
	@Column(name = "ven_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "cliente_cli_id")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Column(name = "ven_data")
	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	@Column(name = "ven_pagamento", nullable = true)
	public int getFormapagamento() {
		return formapagamento;
	}

	public void setFormapagamento(int formapagamento) {
		this.formapagamento = formapagamento;
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
		PedidoVenda other = (PedidoVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PedidoVenda [id=" + id + ", cliente=" + cliente + ", dataVenda=" + dataVenda + "]";
	}

}
