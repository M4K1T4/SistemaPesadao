package br.com.senai.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senai.bean.LoginBean;
import br.com.senai.model.NivelDeAcesso;

public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		LoginBean loginBean = (LoginBean) ((HttpServletRequest) request).getSession().getAttribute("loginBean");
		String contextPath = ((HttpServletRequest) request).getContextPath();

		HttpServletRequest req = (HttpServletRequest) request;
		String endereco = req.getRequestURI();

		if (req.getRequestURI().endsWith("/login.xhtml")) {
			
		} else if (loginBean == null || !loginBean.isLoggedIn()) {
			((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");

		} else if (loginBean.getNivelDeAcesso() == NivelDeAcesso.ATENDENTE && !(endereco.contains("venda")
				|| endereco.contains("index") || endereco.contains("restrito") || endereco.contains("list")
				|| endereco.contains("pedido_template")) || endereco.contains("forn")) {
			((HttpServletResponse) response).sendRedirect(contextPath + "/acessorestrito_template.xhtml");

		} else if (loginBean.getNivelDeAcesso() == NivelDeAcesso.CADASTRANTE
				&& !(endereco.contains("cad") || endereco.contains("index") || endereco.contains("restrito"))) {
			((HttpServletResponse) response).sendRedirect(contextPath + "/acessorestrito_template.xhtml");

		} else if (loginBean.getNivelDeAcesso() == NivelDeAcesso.COORDENADORDECOMPRA
				&& !(endereco.contains("compra") || endereco.contains("index") || endereco.contains("restrito"))) {
			((HttpServletResponse) response).sendRedirect(contextPath + "/acessorestrito_template.xhtml");

		} else if (loginBean.getNivelDeAcesso() == NivelDeAcesso.COORDENADORFINANCEIRO
				&& !(endereco.contains("conta") || endereco.contains("index") || endereco.contains("restrito"))) {
			((HttpServletResponse) response).sendRedirect(contextPath + "/acessorestrito_template.xhtml");

		}

		chain.doFilter(request, response);

	}

}