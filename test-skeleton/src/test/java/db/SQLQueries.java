package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLQueries {
	private final String url = "jdbc:h2:tcp://localhost:8762/mem:userdb?IFEXISTS=false";
	private final String user = "sa";
	private final String pass = "password";

	private String QueryResult(String query) throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, pass);

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		var result = resultSet.toString();

		preparedStatement.close();
		connection.close();

		return result;
	}

	public void printUsers() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, pass);
		PreparedStatement preparedStatement = connection.prepareStatement("select USERNAME from USERS");

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}

		preparedStatement.close();
		connection.close();
	}
}
