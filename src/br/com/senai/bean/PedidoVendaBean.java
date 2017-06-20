package br.com.senai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.senai.dao.ClienteDao;
import br.com.senai.dao.PedidoVendaDAO;
import br.com.senai.model.Cliente;
import br.com.senai.model.PedidoVenda;

@ManagedBean
@SessionScoped
public class PedidoVendaBean {

	private PedidoVenda pedidoVenda = new PedidoVenda();
	private List<PedidoVenda> pedidosVendas = new ArrayList<PedidoVenda>();
	private List<Cliente> clientes;

	public PedidoVendaBean() {
		pedidosVendas = new PedidoVendaDAO().listarPedidosVendas();
		clientes = new ClienteDao().listarClientes();
	}

	public String salvar() {
		
		new PedidoVendaDAO().salvar(pedidoVenda);
		pedidosVendas = new PedidoVendaDAO().listarPedidosVendas();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pedido salvo com sucesso!! "));
		return "pedido_template";
	}
	
	public String editar(PedidoVenda pedidoVenda){
		this.pedidoVenda = pedidoVenda;
		return "null";
	}

	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public List<PedidoVenda> getPedidosVendas() {
		return pedidosVendas;
	}

	public void setPedidosVendas(List<PedidoVenda> pedidosVendas) {
		this.pedidosVendas = pedidosVendas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
