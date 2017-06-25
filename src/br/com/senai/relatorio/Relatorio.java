package br.com.senai.relatorio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Relatorio")
public class Relatorio extends HttpServlet {
	static final long serialVersionUID = 1L;

	private Connection getConnection() {
		Connection connection = null;
		try {
			// cria a conexao com o banco de dados
			Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/tcc?user=root&password=123456";
			connection = DriverManager.getConnection(db);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return connection;

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletOutputStream servletOutputStream = response.getOutputStream();

		String caminho = "/WEB-INF/relatorios/";
		String relatorio = caminho + "ReportEstoque.jasper";
		InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream(relatorio);

		ServletContext context = getServletContext();

		try {

			Connection connection = getConnection();
			// caminho da imagem
			Map<String, Object> map = new HashMap<String, Object>();

			// para gerar o relatorio em PDF
			// o metodo runReportToPdfStream foi usado
			JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, map, connection);

			// envia o relatorio em formato PDF para o browser
			String filename = "relatorio.pdf";
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=" + filename + ";");

			servletOutputStream.flush();
			servletOutputStream.close();
			if (connection != null)
				connection.close();
		} catch (SQLException ex) {
			Logger.getLogger("global").log(Level.SEVERE, null, ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao gerar o relatorio!"));
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao gerar o relatorio!"));
		}

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}