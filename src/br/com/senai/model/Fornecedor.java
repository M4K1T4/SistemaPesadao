package br.com.senai.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = -2128450523234304178L;

	private Integer id;
	private String nomeFornecedor;
	private String fantasiaFornecedor;
	private String cnpjFornecedor;
	private Date cadFornecedor = new Date();
	private String enderecoFornecedor;
	private String bairroFornecedor;
	private String cidadeFornecedor;
	private String complementoFornecedor;
	private String foneaFornecedor;
	private String fonebFornecedor;
	private String ieFornecedor;
	private String imFornecedor;
	private Date fundacaoFornecedor;
	private Estado ufFornecedor;
	private String emailFornecedor;
	private boolean active = true;
	private Date lastUpdate = new Date();

	public Fornecedor() {
		super();
	}

	public Fornecedor(String nomeFornecedor, String fantasiaFornecedor, String cnpjFornecedor, Date cadFornecedor, String enderecoFornecedor,
			String bairroFornecedor, String cidadeFornecedor, String complementoFornecedor, String foneaFornecedor, String fonebFornecedor,
			String ieFornecedor, String imFornecedor, Date fundacaoFornecedor, Estado ufFornecedor, String emailFornecedor) {
		super();
		this.nomeFornecedor = nomeFornecedor;
		this.fantasiaFornecedor = fantasiaFornecedor;
		this.cnpjFornecedor = cnpjFornecedor;
		this.cadFornecedor = cadFornecedor;
		this.enderecoFornecedor = enderecoFornecedor;
		this.bairroFornecedor = bairroFornecedor;
		this.cidadeFornecedor = cidadeFornecedor;
		this.complementoFornecedor = complementoFornecedor;
		this.foneaFornecedor = foneaFornecedor;
		this.fonebFornecedor = fonebFornecedor;
		this.ieFornecedor = ieFornecedor;
		this.imFornecedor = imFornecedor;
		this.fundacaoFornecedor = fundacaoFornecedor;
		this.ufFornecedor = ufFornecedor;
		this.emailFornecedor = emailFornecedor;
	}

	@GeneratedValue
	@Id
	@Column(name = "for_id", length = 50)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "for_razaoSocial", length = 50)
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	@Column(name = "for_nomeFantasia", length = 50)
	public String getFantasiaFornecedor() {
		return fantasiaFornecedor;
	}

	public void setFantasiaFornecedor(String fantasiaFornecedor) {
		this.fantasiaFornecedor = fantasiaFornecedor;
	}

	@CNPJ
	@Column(name = "for_cnpj", length = 50)
	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}

	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}

	@Column(name = "for_dataCadastro", length = 50)
	public Date getCadFornecedor() {
		return cadFornecedor;
	}

	public void setCadFornecedor(Date cadFornecedor) {
		this.cadFornecedor = cadFornecedor;
	}

	@Column(name = "for_endereco", length = 120)
	public String getEnderecoFornecedor() {
		return enderecoFornecedor;
	}

	public void setEnderecoFornecedor(String enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}

	@Column(name = "for_bairro", length = 50)
	public String getBairroFornecedor() {
		return bairroFornecedor;
	}

	public void setBairroFornecedor(String bairroFornecedor) {
		this.bairroFornecedor = bairroFornecedor;
	}

	@Column(name = "for_cidade", length = 50)
	public String getCidadeFornecedor() {
		return cidadeFornecedor;
	}

	public void setCidadeFornecedor(String cidadeFornecedor) {
		this.cidadeFornecedor = cidadeFornecedor;
	}

	@Column(name = "for_complemento", length = 50)
	public String getComplementoFornecedor() {
		return complementoFornecedor;
	}

	public void setComplementoFornecedor(String complementoFornecedor) {
		this.complementoFornecedor = complementoFornecedor;
	}

	@Column(name = "for_foneA", length = 50)
	public String getFoneaFornecedor() {
		return foneaFornecedor;
	}

	public void setFoneaFornecedor(String foneaFornecedor) {
		this.foneaFornecedor = foneaFornecedor;
	}

	@Column(name = "for_foneB", length = 50)
	public String getFonebFornecedor() {
		return fonebFornecedor;
	}

	public void setFonebFornecedor(String fonebFornecedor) {
		this.fonebFornecedor = fonebFornecedor;
	}

	@Column(name = "for_ie", length = 50)
	public String getIeFornecedor() {
		return ieFornecedor;
	}

	public void setIeFornecedor(String ieFornecedor) {
		this.ieFornecedor = ieFornecedor;
	}

	@Column(name = "for_im", length = 50)
	public String getImFornecedor() {
		return imFornecedor;
	}

	public void setImFornecedor(String imFornecedor) {
		this.imFornecedor = imFornecedor;
	}

	@Column(name = "for_dataFundacao", length = 50)
	@Temporal(TemporalType.DATE)
	public Date getFundacaoFornecedor() {
		return fundacaoFornecedor;
	}

	public void setFundacaoFornecedor(Date fundacaoFornecedor) {
		this.fundacaoFornecedor = fundacaoFornecedor;
	}

	@Column(name = "for_uf", length = 50)
	public Estado getUfFornecedor() {
		return ufFornecedor;
	}

	public void setUfFornecedor(Estado ufFornecedor) {
		this.ufFornecedor = ufFornecedor;
	}

	@Email
	@Column(name = "for_email", length = 120)
	public String getEmailFornecedor() {
		return emailFornecedor;
	}


	public void setEmailFornecedor(String emailFornecedor) {
		this.emailFornecedor = emailFornecedor;
	}

	@Column(name = "for_active", length = 50)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "for_lastUpdate", length = 50)
	@Temporal(TemporalType.DATE)
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nomeFornecedor=" + nomeFornecedor + ", fantasiaFornecedor="
				+ fantasiaFornecedor + ", cnpjFornecedor=" + cnpjFornecedor + ", cadFornecedor=" + cadFornecedor
				+ ", enderecoFornecedor=" + enderecoFornecedor + ", bairroFornecedor=" + bairroFornecedor
				+ ", cidadeFornecedor=" + cidadeFornecedor + ", complementoFornecedor=" + complementoFornecedor
				+ ", foneaFornecedor=" + foneaFornecedor + ", fonebFornecedor=" + fonebFornecedor + ", ieFornecedor="
				+ ieFornecedor + ", imFornecedor=" + imFornecedor + ", fundacaoFornecedor=" + fundacaoFornecedor
				+ ", ufFornecedor=" + ufFornecedor + ", emailFornecedor=" + emailFornecedor + ", active=" + active
				+ ", lastUpdate=" + lastUpdate + "]";
	}

	

}