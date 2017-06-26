package br.com.senai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import br.com.senai.dao.EstoqueDAO;
import br.com.senai.model.Estoque;
import br.com.senai.relatorio.ReportFactory;

@ManagedBean
@SessionScoped
public class EstoqueBean {

	private List<Estoque> listEstoque = new ArrayList<>();

	public EstoqueBean() {
		listEstoque = new EstoqueDAO().listarEstoque();
	}

	public void getRelatorio() {
		ReportFactory report = new ReportFactory();
		if (listEstoque.size() > 0) {
			report.getRelatorio();
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não há registros!"));
		}
	}

	public List<Estoque> getListEstoque() {
		return listEstoque;
	}

	public void setListEstoque(List<Estoque> listEstoque) {
		this.listEstoque = listEstoque;
	}

}
