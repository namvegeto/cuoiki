package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import controller.user;

public class userModel{
    private static final String JDBC_URL = "jdbc:mySQL://localhost:3306/dulieu";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public ArrayList<user> getAllUsers() {
        ArrayList<user> userList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    // Assuming you have a User class with appropriate constructors and setters
                    
                    int id = resultSet.getInt("User ID");
                    System.out.println(id);
                    String name = resultSet.getString("Name");
                    String phone = resultSet.getString("Phone");
                    String username = resultSet.getString("Username");
                    String password = resultSet.getString("Password");
                    user user = new user(id,name,phone,username,password);
                    // Add more fields as needed

                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public static void print() {
        userModel userDAO = new userModel();
        List<user> userList = userDAO.getAllUsers();

        for (user user : userList) {
            System.out.println(user);
        }
    }
}

