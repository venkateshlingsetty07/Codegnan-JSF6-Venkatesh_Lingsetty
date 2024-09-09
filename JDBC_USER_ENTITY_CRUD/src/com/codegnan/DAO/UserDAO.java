 
package com.codegnan.DAO;
 
import java.util.List;
 
import com.codegnan.entity.User;
 
public interface UserDAO {
	void addUser(User user);
	User getUserById(int id);
	List<User> getAllUsers();
	void updateUser(User user);
	void deleteUser(int id);
}
 
 
 
 
