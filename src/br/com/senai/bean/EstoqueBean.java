package br.com.senai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.senai.dao.EstoqueDAO;
import br.com.senai.model.Estoque;

@ManagedBean
@SessionScoped
public class EstoqueBean {

	private List<Estoque> listEstoque = new ArrayList<>();
	
	public EstoqueBean() {
		listEstoque = new EstoqueDAO().listarEstoque();
	}

	public List<Estoque> getListEstoque() {
		return listEstoque;
	}

	public void setListEstoque(List<Estoque> listEstoque) {
		this.listEstoque = listEstoque;
	}
	
	
	
}
