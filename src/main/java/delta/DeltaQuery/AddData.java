package delta.DeltaQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AddData {
	public void Add() {
		String name = "";
		float price = 0;
		String sql = "insert into item (name, price) values(?, ?)";
		System.out.println("Inserting....");

		Connection con = new DB_Connection().getDbConnection();
		try {
			Statement statement = con.createStatement();
			Scanner scanner = new Scanner(System.in);

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			System.out.println("Enter no. of record : ");
			int n = scanner.nextInt();
			while (n > 0) {
				System.out.println("Enter name : ");
				name = scanner.next();
				System.out.println("Enter price : ");
				price = scanner.nextFloat();
				preparedStatement.setString(1, name);
				preparedStatement.setFloat(2, price);
				preparedStatement.executeUpdate();
				n--;
			}
			System.out.println("Done....");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
