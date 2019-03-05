package Sonda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
public class PRU05Exemple_connexio {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		try {

			connect = DriverManager
					.getConnection("jdbc:mysql://172.16.26.200/Temperatures?useSSL=false&"
							+ "user=alumne&password=tofol");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement
					.executeQuery("select ubicacio,data from Temperatures");
			writeResultSet(resultSet);


		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}


	private void writeResultSet(ResultSet resultSet) throws SQLException {

		while (resultSet.next()) {
			// It is possible to get the columns via name
			// but also possible to get the columns via the column number
			// starting at 1
			// e.g. resultSet.getSTring(2);

			String ubicacio = resultSet.getString("ubicacio");
			Date data = resultSet.getDate("data");

			System.out.println(ubicacio);
			System.out.println(data);
			
		}
	}

	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}