package br.com.senai.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.senai.model.Fornecedor;

@FacesConverter("fornecedorConverter")
public class FornecedorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		if (valor.equals("") || !valor.contains("#")) {
			return null;
		}

		Fornecedor fornecedor = new Fornecedor();

		String[] propriedades = valor.split("#");

		if (!propriedades[0].isEmpty()) {
			fornecedor.setId(new Integer(propriedades[0]));
			System.out.println("ID do Fornecedor chegou no converter");
		}

		if (!propriedades[1].isEmpty()) {
			fornecedor.setFantasiaFornecedor(propriedades[1]);
		}
		return fornecedor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj == null || !(obj instanceof Fornecedor)) {
			return "";
		}

		Fornecedor fornecedor = (Fornecedor) obj;

		String id = fornecedor.getId() == null ? "" : fornecedor.getId().toString();
		
		String nome = fornecedor.getFantasiaFornecedor() == null ? "" : fornecedor.getFantasiaFornecedor();
		return id + "#" + nome;
	}
}
