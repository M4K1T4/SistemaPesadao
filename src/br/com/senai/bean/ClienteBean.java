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
import br.com.senai.model.SexoCliente;

/** 
* @author Equipe 1 (Leonardo Andr�, Luan Magalh�es, Matheus Garcia, Vinicius Andrade)
*/
/**
 * Classe para persist�ncia de cliente: m�todos de salvar, excluir e editar.
 */
@ManagedBean
@SessionScoped
public class ClienteBean {
	private Cliente cliente = new Cliente();
	private List<Estado> estados = Arrays.asList(Estado.values());
	private List<SexoCliente> sexos = Arrays.asList(SexoCliente.values());
	private List<Cliente> clientes = new ArrayList<Cliente>();

	/**
	 * M�todo construtor tem a finalidade de criar um objeto em mem�ria.
	 */
	public ClienteBean() {
		clientes = new ClienteDao().listarClientes();
	}

	/**
	 * @return clientelist_template
	 * @throws InterruptedException
	 * 
	 *             M�todo para salvar todas as informa��es de cliente.
	 *             Retornando mensagem de sucesso.
	 */
	@SuppressWarnings("static-access")
	public String salvar() throws InterruptedException {
		new ClienteDao().salvar(cliente);
		clientes = new ClienteDao().listarClientes();
		cliente = new Cliente();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("cliente salvo com sucesso"));
		return "clientelist_template";
	}

	/**
	 * @param cliente
	 * @return clientecad_template M�todo para editar, altera informa��es j�
	 *         cadastradas.
	 */
	public String editar(Cliente cliente) {
		this.cliente = cliente;
		return "clientecad_template";
	}

	/**
	 * 
	 * @param cliente
	 *            M�todo prepararExclusao, respons�vel por colocar cliente
	 *            selecionado na model.
	 */
	public void prepararExclusao(Cliente cliente) {
		this.cliente = cliente;
	}

	// M�todo
	public void excluir() {
		new ClienteDao().excluir(cliente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("cliente deletado com sucesso!"));
		clientes = new ClienteDao().listarClientes();
	}

	/**
	 * M�todo para apanhar data atual do servidor.
	 * 
	 */
	public String getDataAtual() {
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

	public List<SexoCliente> getSexos() {
		return sexos;
	}

	public void setSexos(List<SexoCliente> sexos) {
		this.sexos = sexos;
	}
}