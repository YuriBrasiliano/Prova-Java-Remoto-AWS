package senai.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import senai.util.ConnectionFactory;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection conn; // conecta com o banco de dados
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String cpf = request.getParameter("CPFCliente");
		    String password = request.getParameter("SenhaCliente");

		    try{
				conn = ConnectionFactory.getConnection();
			
		      String sql = "SELECT * FROM clientes WHERE CPFCliente=? AND SenhaCliente=?";
		      PreparedStatement stmt = conn.prepareStatement(sql);
		      stmt.setString(1, cpf.replaceAll("[^0-9]", ""));
		      stmt.setString(2, password);
		      ResultSet rs = stmt.executeQuery();

		      if (rs.next()) {
		        // Cria uma sessão do usuário e redireciona para a página protegida
		        HttpSession session = request.getSession();
		        session.setAttribute("cliente", cpf.replaceAll("[^0-9]", ""));
		        response.sendRedirect("client/conta.jsp");
		      } else {
		    	  PrintWriter out = response.getWriter();
		    	   out.println("<script type=\"text/javascript\">");
		    	   out.println("alert('CPF ou Senha Incorretos! Por favor tentar novamente!');");
		    	   out.println("location='client/index.jsp';");
		    	   out.println("</script>");
		      }

		      // Fecha a conexão com o banco de dados
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
