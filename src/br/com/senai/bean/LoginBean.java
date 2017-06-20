package br.com.senai.bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.senai.model.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {

	private Usuario usuario = new Usuario();

	private String nomeUsuario;
	private String senha;
	private boolean loggedIn;
	
	public String logar() {
		
		FacesContext context = FacesContext.getCurrentInstance();

		if ("Administrador".equals(nomeUsuario) && "123".equals(senha)) {
			
			usuario.setNome(this.nomeUsuario);
			usuario.setDataLogin(new Date());
			
			this.loggedIn = true;

			return "fornecedorlist_template?faces-redirect=true";
			
		} else {
			FacesMessage menssagem = new FacesMessage("Usuário ou senha inválidos!");
			menssagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, menssagem);
		}

		return null;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {	
		this.loggedIn = loggedIn;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
