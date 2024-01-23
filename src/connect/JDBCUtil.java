/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			// Dang ky MySQL Driver voi DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//Cac thong so
			String url = "jdbc:mySQL://localhost:3306/bookstore";
			String userName = "root";
			String password = "";
			//Tao ket noi 
			c = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
		}
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//	public static void printInfo(Connection c) {
//		try {
//			if (c != null) {
//				DatabaseMetaData mtdt = c.getMetaData();
//				System.out.println(mtdt.getDatabaseProductName());
//				System.out.println(mtdt.getDatabaseProductVersion());
//			} 
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
}
