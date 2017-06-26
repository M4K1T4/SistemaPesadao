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

/**
 * @author Equipe 1 (Leonardo André, Luan Magalhães, Matheus Garcia, Vinicius
 *         Andrade)
 */
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = -3954610511847217717L;
	private Integer id;
	private String nomeCliente;
	private SexoCliente sexoCliente;
	private String idadeCliente;
	private String cpfCliente;
	private String enderecoCliente;
	private String numeroResidencialCliente;
	private String bairroCliente;
	private String cidadeCliente;
	private Estado ufCliente;
	private String telefoneCliente;
	private String celularCliente;
	private String emailCliente;
	private Date dataCadCliente = new Date();
	private Date lastUpdateCliente = new Date();
	private boolean active = true;

	/**
	 * Método construtor obrigatório
	 */
	public Cliente() {
	}

	/**
	 * 
	 * @param nomeCli
	 * @param sexoCli
	 * @param idadeCli
	 * @param cpfCli
	 * @param enderecoCli
	 * @param numeroResidencialCli
	 * @param bairroCli
	 * @param cidadeCli
	 * @param ufCli
	 * @param telefoneCli
	 * @param celularCli
	 * @param emailCli
	 * @param dataCadCli
	 *            Método construtor com todas as variáveis necessárias.
	 */
	public Cliente(String nomeCli, SexoCliente sexoCli, String idadeCli, String cpfCli, String enderecoCli,
			String numeroResidencialCli, String bairroCli, String cidadeCli, Estado ufCli, String telefoneCli,
			String celularCli, String emailCli, Date dataCadCli) {
		super();
		this.nomeCliente = nomeCli;
		this.sexoCliente = sexoCli;
		this.idadeCliente = idadeCli;
		this.cpfCliente = cpfCli;
		this.enderecoCliente = enderecoCli;
		this.numeroResidencialCliente = numeroResidencialCli;
		this.bairroCliente = bairroCli;
		this.cidadeCliente = cidadeCli;
		this.ufCliente = ufCli;
		this.telefoneCliente = telefoneCli;
		this.celularCliente = celularCli;
		this.emailCliente = emailCli;
		this.dataCadCliente = dataCadCli;
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
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	@CPF
	@Column(name = "cli_cpf")
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	@Column(name = "cli_sexo")
	@Enumerated(EnumType.STRING)
	public SexoCliente getSexoCliente() {
		return sexoCliente;
	}

	public void setSexoCliente(SexoCliente sexoCliente) {
		this.sexoCliente = sexoCliente;
	}

	@Column(name = "cli_idade")
	public String getIdadeCliente() {
		return idadeCliente;
	}

	public void setIdadeCliente(String idadeCliente) {
		this.idadeCliente = idadeCliente;
	}

	@Column(name = "cli_endereco")
	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	@Column(name = "cli_numeroResidencial")
	public String getNumeroResidencialCliente() {
		return numeroResidencialCliente;
	}

	public void setNumeroResidencialCliente(String numeroResidencialCliente) {
		this.numeroResidencialCliente = numeroResidencialCliente;
	}

	@Column(name = "cli_bairro")
	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	@Column(name = "cli_cidade")
	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	@Column(name = "cli_uf")
	public Estado getUfCliente() {
		return ufCliente;
	}

	public void setUfCliente(Estado ufCliente) {
		this.ufCliente = ufCliente;
	}

	@Column(name = "cli_telefone")
	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	@Column(name = "cli_celular")
	public String getCelularCliente() {
		return celularCliente;
	}

	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}

	@Email
	@Column(name = "cli_email")
	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Column(name = "cli_lastUpdate")
	@Temporal(TemporalType.DATE)
	public Date getLastUpdateCliente() {
		return lastUpdateCliente;
	}

	public void setLastUpdateCliente(Date lastUpdateCliente) {
		this.lastUpdateCliente = lastUpdateCliente;
	}

	@Column(name = "cli_data_cadastro")
	@Temporal(TemporalType.DATE)
	public Date getDataCadCliente() {
		return dataCadCliente;
	}

	public void setDataCadCliente(Date dataCadCliente) {
		this.dataCadCliente = dataCadCliente;
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
		return "Cliente [id=" + id + ", nomeCli=" + nomeCliente + ", cpfCli=" + cpfCliente + ", dataCadCli=" + dataCadCliente
				+ ", active=" + active + "]";
	}
}