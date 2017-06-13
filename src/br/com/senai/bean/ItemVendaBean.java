package br.com.senai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.senai.dao.ItemVendaDAO;
import br.com.senai.dao.ProdutoDAO;
import br.com.senai.model.Produto;
import br.com.senai.model.ItemVenda;

@ManagedBean
@SessionScoped
public class ItemVendaBean {
	private ItemVenda itemVenda = new ItemVenda();
	private List<ItemVenda> itensVendas = new ArrayList<ItemVenda>();
	private List<Produto> produtos;

	public ItemVendaBean() {
		itensVendas = new ItemVendaDAO().listarItensVenda();
		produtos = new ProdutoDAO().listarProdutos();
	}

	public String salvar() {
		new ItemVendaDAO().salvar(itemVenda);
		// pedidosVendas.add(pedidoVenda);
		itensVendas = new ItemVendaDAO().listarItensVenda();
		itemVenda = new ItemVenda();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item salvo com sucesso!! "));
		// return "produtolist_template?faces-redirect=true";
		return "null";
	}

	public void editar(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
		;
	}

	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

	public List<ItemVenda> getItensVendas() {
		return itensVendas;
	}

	public void setItensVendas(List<ItemVenda> itensVendas) {
		this.itensVendas = itensVendas;
	}

	public List<Produto> getClientes() {
		return produtos;
	}

	public void setClientes(List<Produto> clientes) {
		this.produtos = clientes;
	}
}
