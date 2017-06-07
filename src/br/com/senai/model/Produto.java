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
public class Produto implements Serializable {

	private static final long serialVersionUID = 1362690614821775345L;

	private long id;
	private Date cadastroProduto = new Date();
	private String nomeProduto;
	private String marcaProduto;
	private String materiaPrimaProduto;
	private String corProduto;
	private Fornecedor fornecedorProduto;
	private boolean status = true;
	private Date lastUpdate = new Date();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "pro_cadastro", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getCadastroProduto() {
		return cadastroProduto;
	}

	public void setCadastroProduto(Date cadastroProduto) {
		this.cadastroProduto = cadastroProduto;
	}

	@Column(name = "pro_nome", length = 120, nullable = false)
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Column(name = "pro_marca", length = 120, nullable = true)
	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	@Column(name = "pro_materia_prima", length = 120, nullable = true)
	public String getMateriaPrimaProduto() {
		return materiaPrimaProduto;
	}

	public void setMateriaPrimaProduto(String materiaPrimaProduto) {
		this.materiaPrimaProduto = materiaPrimaProduto;
	}

	@Column(name = "pro_cor", length = 120, nullable = false)
	public String getCorProduto() {
		return corProduto;
	}

	public void setCorProduto(String corProduto) {
		this.corProduto = corProduto;
	}

	@ManyToOne
	@JoinColumn(name = "pro_fornecedor", nullable = false)
	public Fornecedor getFornecedorProduto() {
		return fornecedorProduto;
	}

	public void setFornecedorProduto(Fornecedor fornecedorProduto) {
		this.fornecedorProduto = fornecedorProduto;
	}

	@Column(name = "pro_status", columnDefinition = "BINARY(1)", nullable = false)
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "pro_lastUpdate", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", cadastroProduto=" + cadastroProduto + ", nomeProduto=" + nomeProduto
				+ ", marcaProduto=" + marcaProduto + ", materiaPrimaProduto=" + materiaPrimaProduto + ", corProduto="
				+ corProduto + ", fornecedorProduto=" + fornecedorProduto + ", status=" + status + ", lastUpdate="
				+ lastUpdate + "]";
	}

}
