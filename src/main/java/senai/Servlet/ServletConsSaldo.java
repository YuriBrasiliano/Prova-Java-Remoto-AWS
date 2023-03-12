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


@WebServlet("/ServletConsSaldo")
public class ServletConsSaldo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn; // conecta com o banco de dados 
	
    public ServletConsSaldo() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try{
			conn = ConnectionFactory.getConnection();
		
	      String sql = "SELECT saldoConta FROM conta WHERE numConta=?";
	      PreparedStatement stmt = conn.prepareStatement(sql);
	      stmt.setString(1, request.getParameter("saldoteste"));
	      ResultSet rs = stmt.executeQuery();
	      PrintWriter out = response.getWriter();
          while (rs.next()) {
              out.println(rs.getString("saldoConta"));
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
