package se.web_project.user.User;

import java.util.List;



public interface UsersRepository {

	public void deleteUser(int id);

	public void updateUser(User user);

	public void createUser(User user);
	
	public User getUser(int id);

	//public String getAllUsers();

	public List<User>  getAllUsers();
	//public void deleteUser(int i, boolean containsValue);

	//public void deleteUser(int i, String string);

}