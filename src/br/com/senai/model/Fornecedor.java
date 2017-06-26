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
	private String nomeForn;
	private String fantasiaForn;
	private String cnpjForn;
	private Date cadForn = new Date();
	private String enderecoForn;
	private String bairroForn;
	private String cidadeForn;
	private String complementoForn;
	private String foneaForn;
	private String fonebForn;
	private String ieForn;
	private String imForn;
	private Date fundacaoForn;
	private Estado ufForn;
	private String emailForn;
	private boolean active = true;
	private Date lastUpdate = new Date();

	public Fornecedor() {
		super();
	}

	public Fornecedor(String nomeForn, String fantasiaForn, String cnpjForn, Date cadForn, String enderecoForn,
			String bairroForn, String cidadeForn, String complementoForn, String foneaForn, String fonebForn,
			String ieForn, String imForn, Date fundacaoForn, Estado ufForn, String emailForn) {
		super();
		this.nomeForn = nomeForn;
		this.fantasiaForn = fantasiaForn;
		this.cnpjForn = cnpjForn;
		this.cadForn = cadForn;
		this.enderecoForn = enderecoForn;
		this.bairroForn = bairroForn;
		this.cidadeForn = cidadeForn;
		this.complementoForn = complementoForn;
		this.foneaForn = foneaForn;
		this.fonebForn = fonebForn;
		this.ieForn = ieForn;
		this.imForn = imForn;
		this.fundacaoForn = fundacaoForn;
		this.ufForn = ufForn;
		this.emailForn = emailForn;
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
	public String getNomeForn() {
		return nomeForn;
	}

	public void setNomeForn(String nomeForn) {
		this.nomeForn = nomeForn;
	}

	@Column(name = "for_nomeFantasia", length = 50)
	public String getFantasiaForn() {
		return fantasiaForn;
	}

	public void setFantasiaForn(String fantasiaForn) {
		this.fantasiaForn = fantasiaForn;
	}

	@CNPJ
	@Column(name = "for_cnpj", length = 50)
	public String getCnpjForn() {
		return cnpjForn;
	}

	public void setCnpjForn(String cnpjForn) {
		this.cnpjForn = cnpjForn;
	}

	@Column(name = "for_dataCadastro", length = 50)
	public Date getCadForn() {
		return cadForn;
	}

	public void setCadForn(Date cadForn) {
		this.cadForn = cadForn;
	}

	@Column(name = "for_endereco", length = 120)
	public String getEnderecoForn() {
		return enderecoForn;
	}

	public void setEnderecoForn(String enderecoForn) {
		this.enderecoForn = enderecoForn;
	}

	@Column(name = "for_bairro", length = 50)
	public String getBairroForn() {
		return bairroForn;
	}

	public void setBairroForn(String bairroForn) {
		this.bairroForn = bairroForn;
	}

	@Column(name = "for_cidade", length = 50)
	public String getCidadeForn() {
		return cidadeForn;
	}

	public void setCidadeForn(String cidadeForn) {
		this.cidadeForn = cidadeForn;
	}

	@Column(name = "for_complemento", length = 50)
	public String getComplementoForn() {
		return complementoForn;
	}

	public void setComplementoForn(String complementoForn) {
		this.complementoForn = complementoForn;
	}

	@Column(name = "for_foneA", length = 50)
	public String getFoneaForn() {
		return foneaForn;
	}

	public void setFoneaForn(String foneaForn) {
		this.foneaForn = foneaForn;
	}

	@Column(name = "for_foneB", length = 50)
	public String getFonebForn() {
		return fonebForn;
	}

	public void setFonebForn(String fonebForn) {
		this.fonebForn = fonebForn;
	}

	@Column(name = "for_ie", length = 50)
	public String getIeForn() {
		return ieForn;
	}

	public void setIeForn(String ieForn) {
		this.ieForn = ieForn;
	}

	@Column(name = "for_im", length = 50)
	public String getImForn() {
		return imForn;
	}

	public void setImForn(String imForn) {
		this.imForn = imForn;
	}

	@Column(name = "for_dataFundacao", length = 50)
	@Temporal(TemporalType.DATE)
	public Date getFundacaoForn() {
		return fundacaoForn;
	}

	public void setFundacaoForn(Date fundacaoForn) {
		this.fundacaoForn = fundacaoForn;
	}

	@Column(name = "for_uf", length = 50)
	public Estado getUfForn() {
		return ufForn;
	}

	public void setUfForn(Estado ufForn) {
		this.ufForn = ufForn;
	}

	@Email
	@Column(name = "for_email", length = 120)
	public String getEmailForn() {
		return emailForn;
	}

	public void setEmailForn(String emailForn) {
		this.emailForn = emailForn;
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nomeForn=" + nomeForn + ", fantasiaForn=" + fantasiaForn + ", cnpjForn="
				+ cnpjForn + ", cadForn=" + cadForn + ", enderecoForn=" + enderecoForn + ", bairroForn=" + bairroForn
				+ ", cidadeForn=" + cidadeForn + ", complementoForn=" + complementoForn + ", foneaForn=" + foneaForn
				+ ", fonebForn=" + fonebForn + ", ieForn=" + ieForn + ", imForn=" + imForn + ", fundacaoForn="
				+ fundacaoForn + ", ufForn=" + ufForn + ", emailForn=" + emailForn + ", active=" + active
				+ ", lastUpdate=" + lastUpdate + "]";
	}

}