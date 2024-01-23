package controller;

public class user {
	int user_id;
	String name;
	String phone;
	String username;
	String password;
	public user(int user_id,String name,String phone,String username, String password) {
		this.user_id = user_id;
		this.name = name;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}
	public void print() {
		System.out.println(this.name);
	}
}
