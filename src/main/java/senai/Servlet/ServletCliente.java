package senai.Servlet;


import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import senai.dao.ClienteDAO;
import senai.model.Cliente;


@WebServlet("/ServletCliente")

public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
  	    throws ServletException, IOException {
  	        response.setContentType("text/html;charset=UTF-8");
  	        String cmd = request.getParameter("cmd");
  	        ClienteDAO dao;
  	        Cliente cliente = new Cliente();
  	        if (cmd != null) {
  	            try {
  	            	cliente.setCPFCliente(request.getParameter("cpfCadastro"));  
  	            	cliente.setNomeCliente(request.getParameter("nomeCadastro"));
  	            	cliente.setDataNascimentoCliente(request.getParameter("dateCadastro"));
  	            	cliente.setEnderecoCliente(request.getParameter("EndCadastro"));
  	            	cliente.setSenhaCliente(request.getParameter("SenhaCliente"));
  	             
  	            } catch (Exception ex) {
  	                ex.printStackTrace();
  	            }
  	        }
  	        try {
  	            dao = new ClienteDAO();
  	            RequestDispatcher rd = null;
  	            if (cmd.equalsIgnoreCase("CriarConta")) {
  	                dao.CriarConta(cliente);
  	                rd = request.getRequestDispatcher("/conta.jsp");  	                
  	            }        
  	            // executa a ação de direcionar para a página JSP
  	            rd.forward(request, response);
  	        } catch (Exception e) {
  	            e.printStackTrace();
  	            throw new ServletException(e);
  	            }
  	        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
}