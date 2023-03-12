package senai.util;
import java.sql.*;


public class ConnectionFactory {
	
public static Connection getConnection() throws Exception{
	Connection connection = null;
	try {
        /* Obtém o driver de conexão com o banco de dados */
        Class.forName("com.mysql.cj.jdbc.Driver");

        /* Configura os parâmetros da conexão */
        String username = "admin";
    	String password = "12345678";
    	String url = "jdbc:mysql://database-prova-java-remoto.c7aj4yf2pj5h.sa-east-1.rds.amazonaws.com:3306/mydb";
        
        /* Tenta se conectar */
        connection = DriverManager.getConnection(url, username, password);

        /* Caso a conexão ocorra com sucesso, a conexão é retornada */
        return connection;
        
    } catch (Exception e) {
    	  throw new RuntimeException(e);
    }
}

public static void main(String[] args) throws Exception {
	try{
		Connection conn = ConnectionFactory.getConnection();
		System.out.println("OK");
	}catch (Exception erro) {
		throw new Exception("Erro " + erro.getMessage());
	}
	
}
}

