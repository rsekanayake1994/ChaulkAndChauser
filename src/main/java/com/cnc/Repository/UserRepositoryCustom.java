package com.cnc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jdbc.repository.query.Query;
import com.cnc.Model.UserModel;

public interface UserRepositoryCustom extends JpaRepository<UserModel,String>{
	@Query("select * from user  where telephone = ?1 ")
	UserModel findUserByTelephone(String telephone);
}
