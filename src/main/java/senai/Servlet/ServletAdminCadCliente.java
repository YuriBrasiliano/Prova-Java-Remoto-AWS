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


@WebServlet("/ServletAdminCadCliente")
public class ServletAdminCadCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
       

    public ServletAdminCadCliente() {
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
		finally {
		    try { rs.close(); } catch (Exception e) { /* Ignored */ }
		    try { ps.close(); } catch (Exception e) { /* Ignored */ }
		    try { conn.close(); } catch (Exception e) { /* Ignored */ }
		}
		response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.println("<html><body>");
	      out.println("<center><h1>O Cliente foi cadastrado com sucesso! O número da conta será:</h1>");
	      out.println("<h1>" + numContaCliente + "</h1>");
	      out.println("<h1>Para fazer qualquer movimentação, é preciso criar uma conta para ele!</h1>");
	      out.println("<a href='admin/adminCadConta.jsp'>Clique aqui para Criar a Conta do Cliente</a>");
	      out.println("<br><br><br><br>");
	      out.println("<a href='admin/admin_dashboard.jsp'> Clique aqui para voltar </a></center>");
	      out.println("</body></html>");

	    

	}

}
