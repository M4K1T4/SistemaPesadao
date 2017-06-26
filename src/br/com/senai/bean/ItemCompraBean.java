package br.com.senai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.senai.dao.ItemCompraDAO;
import br.com.senai.model.ItemCompra;
import br.com.senai.model.Produto;

@ManagedBean
@SessionScoped
public class ItemCompraBean {

	private ItemCompra itemcompra = new ItemCompra();
	private List<ItemCompra> itemcompras = new ArrayList<ItemCompra>();
	private List<Produto> produtos;

	private PedidoCompraBean pedidoCompraBean;

	public Thread currentThread;

	public ItemCompraBean() {
		itemcompras = new ItemCompraDAO().listarItemCompras();
		itemcompras.add(new ItemCompra());
	}

	public String salvar()  {
		
		new ItemCompraDAO().salvar(itemcompra);
		itemcompras = new ItemCompraDAO().listarItemCompras();
		itemcompra = new ItemCompra();
		pedidoCompraBean.setUltimoRegistroVenda(0);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecedor salvo com sucesso!"));
		return "pedidocompra_template";
	}

	public String editar(ItemCompra itemcompra) {
		this.itemcompra = itemcompra;
		return "fornecedorlist_template";

	}

	public void prepararExclusao(ItemCompra itemcompra) {
		this.itemcompra = itemcompra;
	}

	public void excluir() {
		new ItemCompraDAO().excluir(itemcompra);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecedor excluido com sucesso!"));
		// fornecedor = new FornecedorDAO().listarFornecedores();
	}

	/**
	 * 
	 * @return itemcompra
	 */
	public ItemCompra getItemcompra() {
		return itemcompra;
	}

	/**
	 * 
	 * @param itemcompra
	 */
	public void setItemcompra(ItemCompra itemcompra) {
		this.itemcompra = itemcompra;
	}

	/**
	 * 
	 * @return Itemcompras
	 */
	public List<ItemCompra> getItemcompras() {
		return itemcompras;
	}

	/**
	 * 
	 * @param itemcompras
	 */
	public void setItemcompras(List<ItemCompra> itemcompras) {
		this.itemcompras = itemcompras;
	}

	/**
	 * @return the produtos
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos
	 *            the produtos to set
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	/**
	 * @return the pedidoCompraBean
	 */
	public PedidoCompraBean getPedidoCompraBean() {
		return pedidoCompraBean;
	}

	/**
	 * @param pedidoCompraBean
	 *            the pedidoCompraBean to set
	 */
	public void setPedidoCompraBean(PedidoCompraBean pedidoCompraBean) {
		this.pedidoCompraBean = pedidoCompraBean;
	}

}