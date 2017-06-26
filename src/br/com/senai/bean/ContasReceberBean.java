package br.com.senai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.senai.dao.ContasReceberDAO;
import br.com.senai.model.ContasReceber;

@ManagedBean
@SessionScoped
public class ContasReceberBean {

	private ContasReceber contasReceber = new ContasReceber();
	private List<ContasReceber> contasAReceber = new ArrayList<ContasReceber>();
	
	
	public ContasReceberBean(){
		contasAReceber = new ContasReceberDAO().listarContas();
	}
	
	public String salvar(){
		new ContasReceberDAO().salvar(contasReceber); 
		contasAReceber = new ContasReceberDAO().listarContas();
		contasReceber = new ContasReceber();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conta salva com sucesso!"));
		return "contareceberlist_template";
	}

	/**
	 * @return the contasReceber
	 */
	public ContasReceber getContasReceber() {
		return contasReceber;
	}

	/**
	 * @param contasReceber the contasReceber to set
	 */
	public void setContasReceber(ContasReceber contasReceber) {
		this.contasReceber = contasReceber;
	}

	/**
	 * @return the contasAReceber
	 */
	public List<ContasReceber> getContasAReceber() {
		return contasAReceber;
	}

	/**
	 * @param contasAReceber the contasAReceber to set
	 */
	public void setContasAReceber(List<ContasReceber> contasAReceber) {
		this.contasAReceber = contasAReceber;
	}
	
	
	
	
}
