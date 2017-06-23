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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
/**
 * 
 * @author Equipe 1
 *
 */
public class ContasReceber implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8432266239100602889L;

	private Integer id;
	private PedidoVenda pedidoVendaConta;
	private double valorPedido;
	private Date dataRegistro = new Date();
	private Date dataPagamento = new Date();

	/**
	 * 
	 * @return id
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn()
	public PedidoVenda getPedidoVendaConta() {
		return pedidoVendaConta;
	}

	/**
	 * 
	 * @param pedidoVendaConta
	 */
	public void setPedidoVendaConta(PedidoVenda pedidoVendaConta) {
		this.pedidoVendaConta = pedidoVendaConta;
	}
	
	/**
	 * 
	 * @return valorPedido
	 */
	@Column()
	public double getValorPedido() {
		return valorPedido;
	}

	/**
	 * 
	 * @param valorPedido
	 */
	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}
	
	/**
	 * 
	 * @return valorPedido
	 */
	
	
	@Temporal(TemporalType.DATE)
	@Column()
	public Date getDataRegistro() {
		return dataRegistro;
	}
	
	/**
	 * 
	 * @param dataRegistro
	 */

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	/**
	 * 
	 * @return dataRegistro
	 */
	
	@Temporal(TemporalType.DATE)
	@Column()
	public Date getDataPagamento() {
		return dataPagamento;
	}
	
	/**
	 * 
	 * @param dataPagamento
	 */

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	/**
	 * @return dataPagamento
	 * 
	 */
	
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
		ContasReceber other = (ContasReceber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContasReceber [id=" + id + ", pedidoVendaConta=" + pedidoVendaConta + ", valorPedido=" + valorPedido
				+ ", dataRegistro=" + dataRegistro + ", dataPagamento=" + dataPagamento + "]";
	}

}
