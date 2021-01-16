package com.cnc.Service;
import java.util.List;
import java.util.Optional;

import com.cnc.Model.UserModel;

public interface UserService {
	List<UserModel> findAllUsers();

	String SaveUser(UserModel userData);

	String UpdateUser(UserModel newUserData);

	Optional<UserModel> findUserById(Integer user_id);

	UserModel findUserByTelephone(String telephone);
}
