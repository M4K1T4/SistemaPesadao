package br.com.senai.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.senai.model.PedidoVenda;
import br.com.senai.model.PedidoVenda;
@FacesConverter("pedidoVendaConverter")
public class PedidoVendaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		if (valor.equals("") || !valor.contains("#")) {
			return null;
		}

		PedidoVenda pedidoVenda = new PedidoVenda();

		String[] propriedades = valor.split("#");
		
		if (!propriedades[0].isEmpty()) {
			pedidoVenda.setId(new Integer(propriedades[0]));
		}
		
		return pedidoVenda;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof PedidoVenda)){
			return "";
		}
		
		PedidoVenda pedidoVenda = (PedidoVenda) obj;
		
		String id = pedidoVenda.getId() == null ? "" : pedidoVenda.getId().toString();
		
		return id + "#";
	}
}
