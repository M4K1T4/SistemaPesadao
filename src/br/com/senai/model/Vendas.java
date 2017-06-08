package br.com.senai.model;

import java.util.Date;

public class Vendas {

	private Integer id;
	private String qtdVenda;
	private double valorVenda;
	private Produto produtoVenda;
	private Cliente clienteVenda;
	private boolean activeVen = true;
	private Date dataVenda = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getQtdVenda() {
		return qtdVenda;
	}

	public void setQtdVenda(String qtdVenda) {
		this.qtdVenda = qtdVenda;
	}


	public Produto getProdutoVenda() {
		return produtoVenda;
	}

	public void setProdutoVenda(Produto produtoVenda) {
		this.produtoVenda = produtoVenda;
	}

	public Cliente getClienteVenda() {
		return clienteVenda;
	}

	public void setClienteVenda(Cliente clienteVenda) {
		this.clienteVenda = clienteVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}


	public boolean isActiveVen() {
		return activeVen;
	}

	public void setActiveVen(boolean activeVen) {
		this.activeVen = activeVen;
	}
	
	
	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
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
		Vendas other = (Vendas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vendas [id=" + id + ", qtdVenda=" + qtdVenda + ", valorVenda=" + valorVenda + ", produtoVenda="
				+ produtoVenda + ", clienteVenda=" + clienteVenda + ", activeVen=" + activeVen + ", dataVenda="
				+ dataVenda + "]";
	}
	
}
