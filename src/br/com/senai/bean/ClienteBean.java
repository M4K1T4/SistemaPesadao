package br.com.senai.bean;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.senai.dao.ClienteDao;
import br.com.senai.model.Cliente;
import br.com.senai.model.Estado;


@ManagedBean
@SessionScoped
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private List<Estado> estados = Arrays.asList(Estado.values());
	private List<Cliente> clientes = new ArrayList<Cliente>();
	public Thread currentThread;

	public ClienteBean() {
		clientes = new ClienteDao().listarClientes();
	}

	@SuppressWarnings("static-access")
	public String salvar() throws InterruptedException {
		Thread.currentThread().sleep(5000);;
		new ClienteDao().salvar(cliente);
		clientes = new ClienteDao().listarClientes();
		cliente = new Cliente();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("cliente salvo com sucesso"));
		return "clientelist_template";
	}

	public String editar(Cliente cliente) {
		this.cliente = cliente;
		return "clientecad_template";
	}
	
	public void prepararExclusao(Cliente cliente){
		this.cliente = cliente;
	}
	
	public void excluir(){
		new ClienteDao().excluir(cliente);
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("cliente deletado com sucesso!"));
		clientes = new ClienteDao().listarClientes();
	}
	
	public String getDataAtual(){
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	
}
