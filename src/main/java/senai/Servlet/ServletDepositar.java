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

import senai.model.Cliente;
import senai.util.ConnectionFactory;


@WebServlet("/ServletDepositar")
public class ServletDepositar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection conn;
	private ResultSet rs; 
	
	
    public ServletDepositar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
	      String sql = "SELECT saldoConta FROM conta WHERE numConta = ?";
	      PreparedStatement stmt = conn.prepareStatement(sql);
	      stmt.setString(1, request.getParameter("depositarvalor").toString());
	      rs = stmt.executeQuery();
          rs.next();
	      float numero = Float.parseFloat(request.getParameter("valorDepositar"));
	      float valorSalvo = rs.getFloat("saldoConta");
	      float novoValor = numero + valorSalvo;
	      
	      String sqldepositar = "UPDATE conta SET saldoConta = ? WHERE numConta=?";
	      PreparedStatement stmtdepositar = conn.prepareStatement(sqldepositar);
	      stmtdepositar.setFloat(1, novoValor);
	      stmtdepositar.setString(2, request.getParameter("depositarvalor").toString());
	      int rs2 = stmtdepositar.executeUpdate();
	      
	      String sqllog = "INSERT INTO transacoes VALUES(?, 'dep', NOW(), ?)";
	      PreparedStatement stmtlog = conn.prepareStatement(sqllog);
	      stmtlog.setFloat(2, numero);
	      stmtlog.setString(1, request.getParameter("depositarvalor"));
	      int rs3 = stmtlog.executeUpdate();		  
	      response.sendRedirect("client/operacaoRealizada.jsp");
	   
          
	      rs.close();
	      stmt.close();
	      conn.close();

	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
