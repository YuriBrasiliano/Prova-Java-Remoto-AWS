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

/**
 * Servlet implementation class ServletExtrato
 */
@WebServlet("/ServletExtrato")
public class ServletExtrato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn; // conecta com o banco de dados

       

    public ServletExtrato() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			conn = ConnectionFactory.getConnection();
		
	      String sql = "SELECT * FROM transacoes WHERE numConta=?";
	      PreparedStatement stmt = conn.prepareStatement(sql);
	      stmt.setString(1, request.getParameter("extratoCliente"));
	      ResultSet rs = stmt.executeQuery();
	      PrintWriter out = response.getWriter();
          while (rs.next()) {
              out.println(rs.getString("valorTransacao"));
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
