package senai.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import senai.util.ConnectionFactory;


@WebServlet("/ServletAdminAlterarConta")
public class ServletAdminAlterarConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
    
	
	
    public ServletAdminAlterarConta() {
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
		
	      String sql = "UPDATE clientes SET nomeCliente = ?, EnderecoCliente = ?, senhaCliente = ? WHERE numContaCliente = ?;";
	      PreparedStatement stmt = conn.prepareStatement(sql);
	      stmt.setString(1, request.getParameter("NomeCompleto"));
	      stmt.setString(2, request.getParameter("EndCadastro"));
	      stmt.setString(3, request.getParameter("SenhaCliente"));
	      stmt.setString(4, request.getParameter("numConta"));
	      int rs = stmt.executeUpdate();
	      
	      response.sendRedirect("admin/dadosAlteradosSucesso.jsp");
	      
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
