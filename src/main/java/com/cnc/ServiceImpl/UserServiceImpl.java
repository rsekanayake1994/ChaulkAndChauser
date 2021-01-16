package com.cnc.ServiceImpl;

import java.util.List;
import java.util.Optional;

import com.cnc.Model.UserModel;
import com.cnc.Service.UserService;

import org.springframework.stereotype.Service;

import com.cnc.Repository.UserRepository;
import com.cnc.Repository.UserRepositoryCustom;




import org.springframework.beans.factory.annotation.Autowired;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepository;
@Autowired
private UserRepositoryCustom userrepositorycustom;
	

	public List<UserModel> findAllUsers() {
		// TODO Auto-generated method stub
		List<UserModel> allusers = userrepository.findAll();
		return allusers;
	}

	public String SaveUser(UserModel userData) {
		// TODO Auto-generated method stub
		userrepository.save(userData);
		return "Data Saved";
	}
	
	public String UpdateUser(UserModel newUserData) {
		String msg=null;
		if(newUserData.getUser_id()!= 0) {
			userrepository.save(newUserData);
			msg= "Data Updated";
		}else {
			msg="Error";
		}
		return msg;
		
	}

	public Optional<UserModel> findUserById(Integer user_id) {
		// TODO Auto-generated method stub
		if(user_id !=null) {
		return userrepository.findById(user_id);
			
		}
		else 
			return null;
		}

	public UserModel findUserByTelephone(String telephone) {
		if(telephone!=null) {
			return userrepositorycustom.findUserByTelephone(telephone);
		}else
		return null;
	}


	
}
