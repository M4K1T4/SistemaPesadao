// @Author: Equipe 1;
// Model Item Venda que ir� abastecer a tabela pedido adequadamente.

package br.com.senai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = -427572366546275720L;

	private Integer id;
	private double valorUnitVenda;
	private int pedidoVenda;
	private Produto produtoVenda;
	private int quantidadeVenda;

	@Id
	@Column(name = "itv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "itv_valorUnitario", nullable = true)
	public double getValorUnitVenda() {
		return valorUnitVenda;
	}

	// @ManyToOne
	// @JoinColumn(name = "pedidoVenda_ven_id")
	@Column(name = "pedidoVenda_ven_id")
	public int getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(int pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public void setValorUnitVenda(double valorUnitVenda) {
		this.valorUnitVenda = valorUnitVenda;
	}

	@Column(name = "itv_qtde")
	public int getQuantidadeVenda() {
		return quantidadeVenda;
	}

	public void setQuantidadeVenda(int quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}

	@ManyToOne
	@JoinColumn(name = "produto_pro_id", nullable = true)
	public Produto getProdutoVenda() {
		return produtoVenda;
	}

	public void setProdutoVenda(Produto produtoVenda) {
		this.produtoVenda = produtoVenda;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVenda other = (ItemVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", valorUnitVenda=" + valorUnitVenda + ", pedidoVenda=" + pedidoVenda
				+ ", produtoVenda=" + produtoVenda + ", quantidadeVenda=" + quantidadeVenda + "]";
	}
}
