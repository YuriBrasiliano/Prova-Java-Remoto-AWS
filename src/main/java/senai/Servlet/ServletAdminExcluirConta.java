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


@WebServlet("/ServletAdminExcluirConta")
public class ServletAdminExcluirConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn; // conecta com o banco de dados 
    public ServletAdminExcluirConta() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			conn = ConnectionFactory.getConnection();
		
	      String sql = "SELECT numConta FROM transacoes WHERE numConta=?";
	      PreparedStatement stmt = conn.prepareStatement(sql);
	      stmt.setString(1, request.getParameter("numConta"));
	      ResultSet rs = stmt.executeQuery();
	      PrintWriter out = response.getWriter();
	      if(rs.next()) {
	    	  out.println("<html><body>");
	          out.println("<h1>A conta possui transações! Logo não poderá ser excluida!</h1>");
	          out.println("</body></html>");
	      }else {
	    	  String sql2 = "DELETE from conta WHERE numConta=?";
		      PreparedStatement stmt2 = conn.prepareStatement(sql2);
		      stmt2.setString(1, request.getParameter("numConta"));
		      int rs2 = stmt2.executeUpdate();
		      
		      String sql3 = "DELETE from clientes WHERE numContaCliente=?";
		      PreparedStatement stmt3 = conn.prepareStatement(sql3);
		      stmt3.setString(1, request.getParameter("numConta"));
		      int rs3 = stmt3.executeUpdate();
		      
		      
	    	  out.println("<html><body>");
	          out.println("<h1>Conta Excluida com Sucesso!</h1>");
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
