package senai.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import senai.model.Cliente;
import senai.util.ConnectionFactory;


@WebServlet("/ServletCriarConta")

public class ServletCriarConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private Connection conn; // conecta com o banco de dados
	private PreparedStatement ps; // permite executar querys
	private ResultSet rs; //


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			conn = ConnectionFactory.getConnection();
		}catch (Exception erro) {
			throw new ServletException("Erro " + erro.getMessage());
		}
		
		
		String numContaCliente = new StringBuilder(request.getParameter("cpfCadastro")).reverse().toString();
	    
	    try {
			String sql = "INSERT INTO clientes(numContaCliente, nomeCliente,DataNascimentoCliente,CPFCliente,EnderecoCliente,senhaCliente)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, numContaCliente);
			ps.setString(2, request.getParameter("nomeCadastro"));
			ps.setString(3, request.getParameter("dateCadastro"));
			ps.setString(4, request.getParameter("cpfCadastro"));
			ps.setString(5, request.getParameter("EndCadastro"));
			ps.setString(6, request.getParameter("SenhaCliente"));
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new ServletException("Erro " + erro.getMessage());
		}
		try {
			String sql = "INSERT INTO conta(numConta,saldoConta,tipoConta)"
					+ "VALUES (?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, numContaCliente);
			ps.setFloat(2, (float) 00.0);
			ps.setString(3, "CC");
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new ServletException("Erro " + erro.getMessage());
		}
		finally {
		    try { rs.close(); } catch (Exception e) { /* Ignored */ }
		    try { ps.close(); } catch (Exception e) { /* Ignored */ }
		    try { conn.close(); } catch (Exception e) { /* Ignored */ }
		}

	    

}}
