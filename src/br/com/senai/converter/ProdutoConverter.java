package br.com.senai.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.senai.model.Produto;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		if (valor.equals("") || !valor.contains("#")) {
			return null;
		}
		
		Produto produto = new Produto();
		
		String[] propriedades = valor.split("#");
		
		if (!propriedades[0].isEmpty()) {
			produto.setId(new Integer(propriedades[0]));
			System.out.println("VALUE DESFUDIDO produto");
		}
		if (!propriedades[1].isEmpty()) {
			produto.setNomeProduto(propriedades[1]);
		}
		return produto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj == null || !(obj instanceof Produto)) {
			return "";
		}
		Produto produto = (Produto) obj;

		String id = produto.getId() == null ? "" : produto.getId().toString();
				
		String nome = produto.getNomeProduto() == null ? "" : produto.getNomeProduto();
		return id + "#" + nome;
	}

}