package br.com.senai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.senai.dao.PedidoCompraDAO;
import br.com.senai.model.PedidoCompra;

@ManagedBean
@SessionScoped
public class PedidoCompraBean {

	private PedidoCompra pedidocompra = new PedidoCompra();
	private List<PedidoCompra> pedidocompras = new ArrayList<PedidoCompra>();
	public Thread currentThread;

	public PedidoCompraBean() {
		pedidocompras = new PedidoCompraDAO().listarPedidoCompras();
		
	}

	public String salvar() throws InterruptedException {
		// fornecedores.add(fornecedor);
		currentThread = Thread.currentThread();
		Thread.sleep(7000);
		new PedidoCompraDAO().salvar(pedidocompra);
		pedidocompras = new PedidoCompraDAO().listarPedidoCompras();
		pedidocompra = new PedidoCompra();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecedor salvo com sucesso!"));
		return "fornecedorlist_template";
	}

	public String editar(PedidoCompra fornecedor) {
		this.pedidocompra = fornecedor;
		return "fornecedorlist_template";

	}

	public void prepararExclusao(PedidoCompra fornecedor) {
		this.pedidocompra = fornecedor;
	}

	public void excluir() {
		new PedidoCompraDAO().excluir(pedidocompra);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecedor excluido com sucesso!"));
		// fornecedor = new FornecedorDAO().listarFornecedores();
	}

	public PedidoCompra getPedidocompra() {
		return pedidocompra;
	}

	public void setPedidocompra(PedidoCompra pedidocompra) {
		this.pedidocompra = pedidocompra;
	}

	public List<PedidoCompra> getPedidocompras() {
		return pedidocompras;
	}

	public void setPedidocompras(List<PedidoCompra> pedidocompras) {
		this.pedidocompras = pedidocompras;
	}

}