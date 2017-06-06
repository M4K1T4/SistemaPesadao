package br.com.senai.model;

public class Vendas {

	private Integer id;
	private String qtdVendas;
	private double valorVenda;
	private int nomeProduto;
	private int fornecedor;
	private boolean activeVen = true;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQtdVendas() {
		return qtdVendas;
	}

	public void setQtdVendas(String qtdVendas) {
		this.qtdVendas = qtdVendas;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(int nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(int fornecedor) {
		this.fornecedor = fornecedor;
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
		return "Vendas [id=" + id + ", qtdVendas=" + qtdVendas + ", valorVenda=" + valorVenda + ", nomeProduto="
				+ nomeProduto + ", fornecedor=" + fornecedor + ", activeVen=" + activeVen + "]";
	}

}
