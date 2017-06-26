package br.com.senai.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportFactory{
	
	private HttpServletResponse response;
	private FacesContext context;
	private Connection con;
	
	public ReportFactory() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) this.context.getExternalContext().getResponse();
	}
	
	
	public void getRelatorio(){
		try{
			
			InputStream stream = this.getClass().getResourceAsStream("/report/ReportEstoque.jasper");
			Map<String, Object> params = new HashMap<String, Object>();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			ImageIcon gto = new ImageIcon(getClass().getResource("/report/Logo.png"));
			params.put("logo", gto.getImage());
			
			//JRBeanCollectionDataSource datasrc = new JRBeanCollectionDataSource(lista);
			
			JasperReport jasper = (JasperReport) JRLoader.loadObject(stream);
			
			JasperPrint print = JasperFillManager.fillReport(jasper, params, getConexao());
			
			JasperExportManager.exportReportToPdfStream(print, baos);
			
			response.reset();
			
			response.setContentType("application/pdf");
			
			response.setContentLength(baos.size());
			
			response.setHeader("Content-disposition","inline; filename=relatorio.pdf");
			
			response.getOutputStream().write(baos.toByteArray());
			
			response.getOutputStream().flush();
			
			response.getOutputStream().close();
			
			context.responseComplete();
			
			closeConnection();
			
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao gerar o relatorio!"));
			System.out.println("Erro ! -------------------------------------------------------------------------------->\n"+e);
		}
		
	}

	
	private Connection getConexao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.68.0.200:3306/tcc", "aluno", "123456");
			return con;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	private void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
