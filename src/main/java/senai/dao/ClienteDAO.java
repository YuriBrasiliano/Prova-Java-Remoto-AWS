package senai.dao;

import java.sql.*;
import senai.model.Cliente;
import senai.util.ConnectionFactory;

public class ClienteDAO {
	
	private Cliente cliente;
	private Connection conn; // conecta com o banco de dados
	private PreparedStatement ps; // permite executar querys
	private ResultSet rs; // tabela
	
	public ClienteDAO() throws Exception{
		try{
			conn = ConnectionFactory.getConnection();
		}catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}
	public void CriarConta(Cliente cliente) throws Exception {
		try {
			String sql = "INSERT INTO clientes(nomeCliente,DataNascimentoCliente,CPFCliente,EnderecoCliente,senhaCliente)"
					+ "VALUES (?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getDataNascimentoCliente());
			ps.setString(3, cliente.getCPFCliente());
			ps.setString(4, cliente.getEnderecoCliente());
			ps.setString(5, cliente.getSenhaCliente());
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}finally {
		    try { rs.close(); } catch (Exception e) { /* Ignored */ }
		    try { ps.close(); } catch (Exception e) { /* Ignored */ }
		    try { conn.close(); } catch (Exception e) { /* Ignored */ }
		}

	}

}
