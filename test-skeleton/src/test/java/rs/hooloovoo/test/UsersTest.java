package rs.hooloovoo.test;


import api.GETCalls;
import api.PUTCalls;
import db.SQLQueries;
import enums.Actions;

import java.sql.*;

import org.junit.BeforeClass;
import org.junit.Test;



public class UsersTest {

	PUTCalls putCalls = new PUTCalls();
	GETCalls getCalls = new GETCalls();

	@BeforeClass
	public void TestSetup() {
		// here should implement preconditions related to this class
	}
	
	
//	@Test
//	public void testUsers() throws SQLException {
//		Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:8762/mem:userdb?IFEXISTS=false",
//				"sa", "password");
//
//		PreparedStatement preparedStatement = connection.prepareStatement("select USERNAME from USERS");
//
//		ResultSet resultSet = preparedStatement.executeQuery();
//
//		while (resultSet.next()) {
//			System.out.println(resultSet.getString(1));
//		}
//
//		preparedStatement.close();
//		connection.close();
//	}

}
