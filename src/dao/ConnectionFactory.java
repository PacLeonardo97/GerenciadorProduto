package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			System.out.println("Procurando o driver...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver encontrado com sucesso!");
		} catch (ClassNotFoundException ex) {
			System.err.println("O driver não foi encontrado.");
		}
	}

	public static Connection conectar() {
		try {
			String server = "localhost";

			String database = "web_produtos";

			String url = "jdbc:mysql://" + server + "/" + database;

			String parameters = "?useTimezone=true&serverTimezone=UTC";

			String username = "root";

			String password = "";
			return DriverManager.getConnection(url + parameters, username, password);
		} catch (SQLException ex) {
			System.err.println("Não foi possível conectar!");
			ex.printStackTrace();
			return null;
		}
	}

}