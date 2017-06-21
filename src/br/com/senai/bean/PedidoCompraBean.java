package br.com.senai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import br.com.senai.dao.FornecedorDAO;
import br.com.senai.dao.ItemCompraDAO;
import br.com.senai.dao.PedidoCompraDAO;
import br.com.senai.model.Fornecedor;
import br.com.senai.model.ItemCompra;
import br.com.senai.model.PedidoCompra;


@ManagedBean
@SessionScoped
public class PedidoCompraBean {

	private PedidoCompra pedidoCompra = new PedidoCompra();
	private ItemCompra itemCompra = new ItemCompra();
	private List<PedidoCompra> pedidosCompras = new ArrayList<PedidoCompra>();
	private List<ItemCompra> itemCompras = new ArrayList<ItemCompra>();
	private List<Fornecedor> fornecedores;
	private boolean skip;



	public void save() {
		FacesMessage msg = new FacesMessage("Sucesso", "Welcome :" + PedidoCompra.class.getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public PedidoCompraBean() {
		pedidosCompras = new PedidoCompraDAO().listarPedidoCompras();
		fornecedores = new FornecedorDAO().listarFornecedores();
	}
	
	public String salvarPedidoVenda() {
		
		new PedidoCompraDAO().salvar(pedidoCompra);
		new ItemCompraDAO().salvar(itemCompra);
		pedidosCompras = new PedidoCompraDAO().listarPedidoCompras();
		itemCompras = new ItemCompraDAO().listarItemCompras();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pedido salvo com sucesso!! "));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Compra salva com sucesso!! "));
		return "pedido_template";
		
	}

	public String salvar() {
		
		new PedidoCompraDAO().salvar(pedidoCompra);
		pedidosCompras = new PedidoCompraDAO().listarPedidoCompras();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pedido salvo com sucesso!! "));
				return "pedido_template";
	
		}
	
	public String editar(PedidoCompra pedidoCompra){
		this.pedidoCompra = pedidoCompra;
		return "null";
	}

	public PedidoCompra getPedidoCompra() {
		return pedidoCompra;
	}

	public void setPedidoCompra(PedidoCompra pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	public ItemCompra getItemCompra() {
		return itemCompra;
	}

	public void setItemCompra(ItemCompra itemCompra) {
		this.itemCompra = itemCompra;
	}

	public List<PedidoCompra> getPedidosCompras() {
		return pedidosCompras;
	}

	public void setPedidosCompras(List<PedidoCompra> pedidosCompras) {
		this.pedidosCompras = pedidosCompras;
	}

	public List<ItemCompra> getItemCompras() {
		return itemCompras;
	}

	public void setItemCompras(List<ItemCompra> itemCompras) {
		this.itemCompras = itemCompras;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
}
