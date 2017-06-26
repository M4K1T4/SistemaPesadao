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
public class ContasPagar implements Serializable {

	private static final long serialVersionUID = 2945904131833194731L;

	private Integer id;
	private PedidoCompra pedidoCompPag;
	private double valTotalPag;
	private double valParcelaPag;
	private Date dataInicialPag = new Date();
	private Date dataFinalPag = new Date();
	private String comentarioPag;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "pag_pedidoCompra")
	public PedidoCompra getPedidoCompPag() {
		return pedidoCompPag;
	}

	public void setPedidoCompPag(PedidoCompra pedidoCompPag) {
		this.pedidoCompPag = pedidoCompPag;
	}

	@Column(name = "pag_valorTotal")
	public double getValTotalPag() {
		return valTotalPag;
	}

	public void setValTotalPag(double valTotalPag) {
		this.valTotalPag = valTotalPag;
	}

	@Column(name = "pag_parcela")
	public double getValParcelaPag() {
		return valParcelaPag;
	}

	public void setValParcelaPag(double valParcelaPag) {
		this.valParcelaPag = valParcelaPag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pag_dataInicial")
	public Date getDataInicialPag() {
		return dataInicialPag;
	}

	public void setDataInicialPag(Date dataInicialPag) {
		this.dataInicialPag = dataInicialPag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pag_dataFinal")
	public Date getDataFinalPag() {
		return dataFinalPag;
	}

	public void setDataFinalPag(Date dataFinalPag) {
		this.dataFinalPag = dataFinalPag;
	}
	
	@Column(name = "pag_descricao")
	public String getComentarioPag() {
		return comentarioPag;
	}

	public void setComentarioPag(String comentarioPag) {
		this.comentarioPag = comentarioPag;
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
		ContasPagar other = (ContasPagar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContasPagar [id=" + id + ", pedidoCompPag=" + pedidoCompPag + ", valTotalPag=" + valTotalPag
				+ ", valParcelaPag=" + valParcelaPag + ", dataInicialPag=" + dataInicialPag + ", dataFinalPag="
				+ dataFinalPag + "]";
	}

}
