package com.cnc.Model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="user")
public class UserModel {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	
	@NotBlank(message = "Name is mandatory")
	@Column(name="name")
	private String name;
	
	@NotBlank(message = "Phone number is mandatory")
	@Column(name="telephone")
	private String telephone;
	
	@NotBlank(message = "Password is mandatory")
	@Column(name="password")
	private String password;
	
	@NotBlank(message = "Username is mandatory")
	@Column(name="username")
	private String username;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
