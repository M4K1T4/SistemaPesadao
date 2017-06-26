package br.com.senai.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.senai.dao.FornecedorDAO;
import br.com.senai.model.Fornecedor;
import br.com.senai.model.Estado;

@ManagedBean
@SessionScoped
public class FornecedorBean {

	private Fornecedor fornecedor = new Fornecedor();
	private List<Estado> estados = Arrays.asList(Estado.values());
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	public Thread currentThread;

	public FornecedorBean() {
		fornecedores = new FornecedorDAO().listarFornecedores();
	}

	public String salvar() throws InterruptedException {
		currentThread = Thread.currentThread();
		Thread.sleep(7000);
		new FornecedorDAO().salvar(fornecedor);
		fornecedores = new FornecedorDAO().listarFornecedores();
		fornecedor = new Fornecedor();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecedor salvo com sucesso!"));
		return "fornecedorlist_template";
	}

	public String editar(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		return "fornecedorlist_template";
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}