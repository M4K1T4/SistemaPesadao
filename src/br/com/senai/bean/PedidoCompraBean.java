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
import br.com.senai.model.PedidoVenda;

@ManagedBean
@SessionScoped
public class PedidoCompraBean {

	private PedidoCompra pedidoCompra = new PedidoCompra();
	private ItemCompra itemCompra = new ItemCompra();
	private List<PedidoCompra> pedidosCompras = new ArrayList<PedidoCompra>();
	private List<ItemCompra> itemCompras = new ArrayList<ItemCompra>();
	private List<Fornecedor> fornecedores;
	private Integer ultimoRegistroVenda = 0;

	public void setPedidocompra(PedidoCompra pedidoCompra){
		this.pedidoCompra = pedidoCompra;
	}
	public void save() {
		FacesMessage msg = new FacesMessage("Sucesso", "Welcome :" + PedidoCompra.class.getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public PedidoCompraBean() {
		pedidosCompras = new PedidoCompraDAO().listarPedidoCompras();
		fornecedores = new FornecedorDAO().listarFornecedores();
	}

	public String salvarPedidoCompra() {

		new PedidoCompraDAO().salvar(pedidoCompra);

		pedidosCompras = new PedidoCompraDAO().listarPedidoCompras();
		resgataIdPedido();
		itemCompra.setId(ultimoRegistroVenda);
		System.out.println(ultimoRegistroVenda);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pedido salvo com sucesso!! "));
		
		return "pedido_template";

	}

	public String editar(PedidoCompra pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
		return "null";
	}
	public Integer resgataIdPedido(){
		Integer ultimoId = 0;
		for(PedidoCompra ped : pedidosCompras){
			ultimoId = ped.getId();
		}
		setUltimoRegistroVenda(ultimoId);
		return ultimoId;
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

	public Integer getUltimoRegistroVenda() {
		return ultimoRegistroVenda;
	}

	public void setUltimoRegistroVenda(Integer ultimoRegistroVenda) {
		this.ultimoRegistroVenda = ultimoRegistroVenda;
	}

}
