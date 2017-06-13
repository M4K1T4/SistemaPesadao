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
import br.com.senai.model.PedidoCompra;

@ManagedBean
@SessionScoped
public class ItemCompraBean {

	private ItemCompra itemcompra = new ItemCompra();
	private List<ItemCompra> itemcompras = new ArrayList<ItemCompra>();
	public Thread currentThread;

	public ItemCompraBean() {
		itemcompras = new ItemCompraDAO().listarItemCompras();
	}

	public String salvar() throws InterruptedException {
		// fornecedores.add(fornecedor);
		currentThread = Thread.currentThread();
		Thread.sleep(7000);
		new ItemCompraDAO().salvar(itemcompra);
		itemcompras = new ItemCompraDAO().listarItemCompras();
		itemcompra = new ItemCompra();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecedor salvo com sucesso!"));
		return "fornecedorlist_template";
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

	public ItemCompra getItemcompra() {
		return itemcompra;
	}

	public void setItemcompra(ItemCompra itemcompra) {
		this.itemcompra = itemcompra;
	}

	public List<ItemCompra> getItemcompras() {
		return itemcompras;
	}

	public void setItemcompras(List<ItemCompra> itemcompras) {
		this.itemcompras = itemcompras;
	}
	

	public void newLine(ActionEvent actionEvent) {
		itemcompras.add(new ItemCompra());
	}


}