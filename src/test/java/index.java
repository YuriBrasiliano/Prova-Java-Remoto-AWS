import java.util.Iterator;
import java.util.List;

import senai.model.Cliente;

public class index {

	public static void main(String[] args) {
		try {
			//ClienteDAO dao = new ClienteDAO();
			Cliente cliente = new Cliente("Teste3", "2020-11-22", "12345678921", "Rua Miami", "123456");
			//dao.CriarConta(cliente);
			System.out.println( "Deu tudo certo");
		}catch(Exception e) {
			System.out.println( e);
		}
		
	}

}
