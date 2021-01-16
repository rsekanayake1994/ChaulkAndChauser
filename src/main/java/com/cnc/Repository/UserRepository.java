package com.cnc.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cnc.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Integer>{

}
