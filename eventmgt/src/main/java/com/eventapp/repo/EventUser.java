package com.eventapp.repo;




import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
@Entity
@Table(name="event_user_table")
public class EventUser {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uId;
	private String username;
	private String password;
	@Column(name="Roles")
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="user_roles")
	public  List<String> roles =new ArrayList<>();
	public EventUser(String username, String password, List<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public EventUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
}
