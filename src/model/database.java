package model;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class database {
  public Connection connect() {
    Connection c = null;
    try {
      DriverManager.registerDriver((Driver)new Driver());
      String url = "jdbc:mySQL://localhost:3306/dulieu";
      String username = "root";
      String password = "";
      c = DriverManager.getConnection(url, username, password);
      System.out.println("done");
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return c;
  }
  
  public static void closeConnection(Connection c) {
    try {
      if (c != null)
        c.close(); 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public static void printInfo(Connection c) {
    try {
      if (c != null) {
        DatabaseMetaData mtdt = c.getMetaData();
        System.out.println(mtdt.getDatabaseProductName());
        System.out.println(mtdt.getDatabaseProductVersion());
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
}