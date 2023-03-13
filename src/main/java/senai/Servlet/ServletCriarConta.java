package senai.Servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import senai.util.ConnectionFactory;


@WebServlet("/ServletCriarConta")

public class ServletCriarConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			conn = ConnectionFactory.getConnection();
		}catch (Exception erro) {
			throw new ServletException("Erro " + erro.getMessage());
		}        
		try {
			String sql = "INSERT INTO clientes(numContaCliente,nomeCliente,DataNascimentoCliente, CPFCliente, EnderecoCliente, senhaCliente)"
					+ "VALUES (?, ?, ?, ?, ? ,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, new StringBuilder(request.getParameter("cpfCadastro")).reverse().toString().replaceAll("[^0-9]", ""));
			ps.setString(2, request.getParameter("nomeCadastro"));
			ps.setString(3, request.getParameter("dateCadastro"));
			ps.setString(4, request.getParameter("cpfCadastro").toString().replaceAll("[^0-9]", ""));
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
			ps.setString(1, new StringBuilder(request.getParameter("cpfCadastro")).reverse().toString().replaceAll("[^0-9]", ""));
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
		response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.println("<html><body>");
	      out.println("<h1>Sua Conta foi criada com Sucesso!</h1>");
	      out.println("<a href='client/index.jsp'> Faça Login Aqui </a>");
	      out.println("</body></html>");

	    

}}
