package senai.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import senai.util.ConnectionFactory;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    response.getWriter().append("Hello, World!");
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		  String username = request.getParameter("EmailAdmin");
		    String password = request.getParameter("SenhaAdmin");

		    try{
				conn = ConnectionFactory.getConnection();
			
		      String sql = "SELECT * FROM user_admin WHERE Email=? AND Senha=?";
		      PreparedStatement stmt = conn.prepareStatement(sql);
		      stmt.setString(1, username);
		      stmt.setString(2, password);
		      ResultSet rs = stmt.executeQuery();

		      if (rs.next()) {
		        // Cria uma sessão do usuário e redireciona para a página protegida
		        HttpSession session = request.getSession();
		        session.setAttribute("admin", username);
		        response.sendRedirect("admin/admin_dashboard.jsp");
		      } else {
		    	  response.sendRedirect("admin/index.jsp");
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
