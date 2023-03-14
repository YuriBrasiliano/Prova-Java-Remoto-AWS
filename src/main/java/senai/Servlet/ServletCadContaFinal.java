package senai.Servlet;

import java.io.IOException;
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

@WebServlet("/ServletCadContaFinal")
public class ServletCadContaFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;

    public ServletCadContaFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			conn = ConnectionFactory.getConnection();
		}catch (Exception erro) {
			throw new ServletException("Erro " + erro.getMessage());
		}
		
		
		String numContaCliente = request.getParameter("numContaCliente").toString();
	
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
		response.sendRedirect("admin/contaCadastradaSucesso.jsp");

	    

}}

