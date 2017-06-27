package br.com.senai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.senai.dao.ContasPagarDAO;
import br.com.senai.model.ContasPagar;

@ManagedBean
@SessionScoped
public class ContasPagarBean {

	private ContasPagar contasPagar = new ContasPagar();
	private List<ContasPagar> listContasPagar = new ArrayList<ContasPagar>();

	public ContasPagarBean() {
		listContasPagar = new ContasPagarDAO().listarContas();
	}

	public String salvar() {
		new ContasPagarDAO().salvar(contasPagar);
		listContasPagar = new ContasPagarDAO().listarContas();
		contasPagar = new ContasPagar();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conta a pagar salva!"));
		return "contaspagarlist_template?faces-redirect=true";
	}
	
	public void excluir(ContasPagar contasPagar) {
		new ContasPagarDAO().excluir(contasPagar);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conta a pagar excluida!"));
		listContasPagar = new ContasPagarDAO().listarContas();
	}

	public ContasPagar getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(ContasPagar contasPagar) {
		this.contasPagar = contasPagar;
	}

	public List<ContasPagar> getListContasPagar() {
		return listContasPagar;
	}

	public void setListContasPagar(List<ContasPagar> listContasPagar) {
		this.listContasPagar = listContasPagar;
	}

}
