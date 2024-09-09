package com.codegnan.DAO;
 
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
import com.codegnan.entity.User;
 
public class JDBCUserDAO implements UserDAO {
	private String url;
	private String username;
	private String password;
 
	public JDBCUserDAO(String url, String username, String password) {
    	this.url = url;
    	this.username = username;
    	this.password = password;
	}
 
	@Override
	public void addUser(User user) {
    	try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	String query = "INSERT INTO users (name, email) VALUES (?, ?)";
        	try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            	statement.setString(1, user.getName());
            	statement.setString(2, user.getEmail());
            	statement.executeUpdate();
 
            	ResultSet resultSet = statement.getGeneratedKeys();
            	if (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
            	}
        	}
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}
 
	@Override
	public User getUserById(int id) {
    	User user = null;
    	try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	String query = "SELECT * FROM users WHERE id=?";
        	try (PreparedStatement statement = connection.prepareStatement(query)) {
            	statement.setInt(1, id);
            	ResultSet resultSet = statement.executeQuery();
 
            	if (resultSet.next()) {
                	user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
            	}
        	}
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
    	return user;
	}
 
	@Override
	public List<User> getAllUsers() {
    	List<User> users = new ArrayList<>();
    	try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	String query = "SELECT * FROM users";
        	try (Statement statement = connection.createStatement();
             	ResultSet resultSet = statement.executeQuery(query)) {
            	while (resultSet.next()) {
                	User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                	user.setEmail(resultSet.getString("email"));
                	users.add(user);
            	}
        	}
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
    	return users;
	}
 
	@Override
	public void updateUser(User user) {
    	try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	String query = "UPDATE users SET name=?, email=? WHERE id=?";
        	try (PreparedStatement statement = connection.prepareStatement(query)) {
            	statement.setString(1, user.getName());
            	statement.setString(2, user.getEmail());
            	statement.setInt(3, user.getId());
            	statement.executeUpdate();
        	}
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}
	}
 
	@Override
	public void deleteUser(int id) {
    	try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	String query = "DELETE FROM users WHERE id=?";
        	try (PreparedStatement statement = connection.prepareStatement(query)) {
            	statement.setInt(1, id);
            	statement.executeUpdate();
        	}
    	} catch (SQLException e) {
  	      e.printStackTrace();
    	}
	}
}
