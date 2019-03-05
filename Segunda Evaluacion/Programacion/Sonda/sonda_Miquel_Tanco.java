package Sonda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class sonda_Miquel_Tanco extends sonda {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public boolean enregistrarTemperatura(String IP, String ubicacio, double valor) {
		return false;
	}

	public double obtenirTemperatura(String ubicacio, Date data) {
		return 0;
	}

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
			
			String ubicacio = resultSet.getString("ubicacio");
			Date data = resultSet.getDate("data");

			System.out.println(ubicacio);
			System.out.println(data);

		}
	}

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

	public static void main(String[] args) throws Exception {
		
		sonda_Miquel_Tanco sonda = new sonda_Miquel_Tanco();
		sonda.readDataBase();


	}
}
