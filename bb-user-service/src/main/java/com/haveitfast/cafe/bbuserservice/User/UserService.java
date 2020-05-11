package com.haveitfast.cafe.bbuserservice.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	public static ArrayList<User> users = new ArrayList();
	private static int idCounter;
	
	static {
		users.add(new User(++idCounter,"Ribhu Mondal","8961409182","RMondal","1234","Admin"));
	}
	
	public static User createUser(User users1) {
		// TODO Auto-generated method stub
		users1.setId(++idCounter);
			users.add(users1);
		return users1;
	}
	
	public static List<User> findAllUser() {
		// TODO Auto-generated method stub
		return users;
	}
	public static List<User> findAllUserExceptThis(long id) {
		// TODO Auto-generated method stub
		ArrayList Clone_list = new ArrayList(); 
	    Clone_list = (ArrayList)users.clone(); 
	    User x=findUserById(id);
	    Clone_list.remove(x);
		return Clone_list;
	}
	
	
	public static User findUserById(long id) {
		// TODO Auto-generated method stub
		for(User i:users) {
			if(i.getId()==id)
				return i;
		}
	return null;
	}
	
	public static User deleteUser(long id) {
		User x = findUserById(id);
		if(x==null)
			return null;
		if(users.remove(x))
			return x;
	 return null;
	}

	public static boolean isUserFound(String username, String password) {

		// TODO Auto-generated method stub
		for(User i:users) {
			if(i.getUsername().equals(username) && i.getPassword().equals(password) )
				return true;
		}
		return false;
	}
	

	public static User findUserByPassword(String username, String password) {
		// TODO Auto-generated method stub
		for(User i:users) {
			if(i.getUsername().equals(username) && i.getPassword().equals(password) )
				return i;
		}
		return null;
	}

	public static User updateUserDetails(long id, User user) {
		// TODO Auto-generated method stub
		User x= findUserById(id);
		x.setFullName(user.getFullName());
		x.setMobile(user.getMobile());
		x.setRole(user.getRole());
		return x;
	}
	
}
