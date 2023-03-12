package senai.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import senai.util.ConnectionFactory;

@WebServlet("/ServletRetirar")
public class ServletRetirar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private ResultSet rs; 

    public ServletRetirar() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try{
			conn = ConnectionFactory.getConnection();
		
	      String sql = "SELECT saldoConta FROM conta WHERE numConta=?";
	      PreparedStatement stmt = conn.prepareStatement(sql);
	      stmt.setString(1, request.getParameter("retirarvalor"));
	      rs = stmt.executeQuery();
          rs.next();
	      int numero = Integer.parseInt(request.getParameter("valorRetirar"));
	      int valorSalvo = rs.getInt("saldoConta");
	      
	      if (numero > valorSalvo) {
              // Retornar mensagem informando que o número é maior
              response.setContentType("text/html");
              PrintWriter out = response.getWriter();
              out.println("<html><body>");
              out.println("<h1>O valor solicitado de " + numero + " é maior do que o valor em conta de (" + valorSalvo + ") por favor solicitar outro valor que não exceda o valor em conta</h1>");
              out.println("<a href='client/conta.jsp'> Voltar </a>");
              out.println("</body></html>");
          } else {
              // Retornar mensagem informando que o número é menor ou igual
        	  int novoValor = valorSalvo - numero;
        			
        	      String sqllog = "INSERT INTO transacoes VALUES(?, 'ret', NOW(), ?)";
        	      PreparedStatement stmtlog = conn.prepareStatement(sqllog);
        	      stmtlog.setInt(2, numero);
        	      stmtlog.setString(1, request.getParameter("retirarvalor"));
        	      int rs2 = stmtlog.executeUpdate();
        	      rs.next();
        	      
        	      String sqlretirar = "UPDATE conta SET saldoConta = ? WHERE numConta=?";
        	      PreparedStatement stmtretirar = conn.prepareStatement(sqlretirar);
        	      stmtretirar.setInt(1, novoValor);
        	      stmtretirar.setString(2, request.getParameter("retirarvalor"));
        	      int rs3 = stmtretirar.executeUpdate();
        	      rs.next();
        		  
              response.setContentType("text/html");
              PrintWriter out = response.getWriter();
              out.println("<html><body>");
              out.println("<h1>O valor solicitado de " + numero + " reais foi retirado de sua conta, novo valor: " + (valorSalvo - numero) + " reais</h1>");
              out.println("<a href='client/conta.jsp'> Voltar </a>");
              out.println("</body></html>");
          }
	      rs.close();
	      stmt.close();
	      conn.close();

	    } catch (ClassNotFoundException | SQLException ex) {
	      throw new ServletException(ex);
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
