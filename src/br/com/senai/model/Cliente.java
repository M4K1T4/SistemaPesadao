// @Author: Equipe 1;
// model de Cliente usado para cadastrar e manter dados do mesmo.

package br.com.senai.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = -3954610511847217717L;

	private Integer id;
	private String nomeCli;
	private SexoCliente sexoCli;
	private String idadeCli;
	private String cpfCli;
	private String enderecoCli;
	private String numeroResidencialCli;
	private String bairroCli;
	private String cidadeCli;
	private Estado ufCli;
	private String telefoneCli;
	private String celularCli;
	private String emailCli;
	private Date dataCadCli = new Date();
	private Date lastUpdateCli = new Date();
	private boolean active = true;

	public Cliente() {
	}

	public Cliente(String nomeCli, SexoCliente sexoCli, String idadeCli, String cpfCli, String enderecoCli,
			String numeroResidencialCli, String bairroCli, String cidadeCli, Estado ufCli, String telefoneCli,
			String celularCli, String emailCli, Date dataCadCli) {
		super();
		this.nomeCli = nomeCli;
		this.sexoCli = sexoCli;
		this.idadeCli = idadeCli;
		this.cpfCli = cpfCli;
		this.enderecoCli = enderecoCli;
		this.numeroResidencialCli = numeroResidencialCli;
		this.bairroCli = bairroCli;
		this.cidadeCli = cidadeCli;
		this.ufCli = ufCli;
		this.telefoneCli = telefoneCli;
		this.celularCli = celularCli;
		this.emailCli = emailCli;
		this.dataCadCli = dataCadCli;
	}

	@Id
	@Column(name = "cli_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "cli_nome")
	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	@CPF
	@Column(name = "cli_cpf")
	public String getCpfCli() {
		return cpfCli;
	}

	public void setCpfCli(String cpfCli) {
		this.cpfCli = cpfCli;
	}

	@Column(name = "cli_sexo")
	@Enumerated(EnumType.STRING)
	public SexoCliente getSexoCli() {
		return sexoCli;
	}

	public void setSexoCli(SexoCliente sexoCli) {
		this.sexoCli = sexoCli;
	}

	@Column(name = "cli_idade")
	public String getIdadeCli() {
		return idadeCli;
	}


	public void setIdadeCli(String idadeCli) {
		this.idadeCli = idadeCli;
	}

	@Column(name = "cli_endereco")
	public String getEnderecoCli() {
		return enderecoCli;
	}

	public void setEnderecoCli(String enderecoCli) {
		this.enderecoCli = enderecoCli;
	}

	@Column(name = "cli_numeroResidencial")
	public String getNumeroResidencialCli() {
		return numeroResidencialCli;
	}

	public void setNumeroResidencialCli(String numeroResidencialCli) {
		this.numeroResidencialCli = numeroResidencialCli;
	}

	@Column(name = "cli_bairro")
	public String getBairroCli() {
		return bairroCli;
	}

	public void setBairroCli(String bairroCli) {
		this.bairroCli = bairroCli;
	}

	@Column(name = "cli_cidade")
	public String getCidadeCli() {
		return cidadeCli;
	}

	public void setCidadeCli(String cidadeCli) {
		this.cidadeCli = cidadeCli;
	}

	@Column(name = "cli_uf")
	public Estado getUfCli() {
		return ufCli;
	}

	public void setUfCli(Estado ufCli) {
		this.ufCli = ufCli;
	}

	@Column(name = "cli_telefone")
	public String getTelefoneCli() {
		return telefoneCli;
	}

	public void setTelefoneCli(String telefoneCli) {
		this.telefoneCli = telefoneCli;
	}

	@Column(name = "cli_celular")
	public String getCelularCli() {
		return celularCli;
	}

	public void setCelularCli(String celularCli) {
		this.celularCli = celularCli;
	}

	@Email
	@Column(name = "cli_email")
	public String getEmailCli() {
		return emailCli;
	}

	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}

	@Column(name = "cli_lastUpdate")
	@Temporal(TemporalType.DATE)
	public Date getLastUpdateCli() {
		return lastUpdateCli;
	}

	public void setLastUpdateCli(Date lastUpdateCli) {
		this.lastUpdateCli = lastUpdateCli;
	}

	@Column(name = "cli_data_cadastro")
	@Temporal(TemporalType.DATE)
	public Date getDataCadCli() {
		return dataCadCli;
	}

	public void setDataCadCli(Date dataCadCli) {
		this.dataCadCli = dataCadCli;
	}

	@Column(name = "cli_status")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nomeCli=" + nomeCli + ", cpfCli=" + cpfCli + ", dataCadCli=" + dataCadCli
				+ ", active=" + active + "]";
	}

}
