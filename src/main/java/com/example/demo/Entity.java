package com.example.demo;


//import jakarta.validation.constraints.Pattern;


public class Entity{
	
	
	private int id;
	private String name;
	private int age;
	
	//@Pattern(regexp="^(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9_]{8,24}+$" ,message="英数大文字1文字以上")
	private String password;
	private String kakuninpassword;
	private String kaishi;
	private String shuryo;
	
	public Entity() {};
	
	public Entity(int id,String name,int age,String password,String kakuninpassword,String kaishi,String shuryo)
	{
		
		this.id=id;
		this.name=name;
		this.age=age;
		this.password=password;
		this.kakuninpassword=kakuninpassword;
		this.kaishi=kaishi;
		this.shuryo=shuryo;
	
	
		
		
	}
	public int getId() {
		
		return this.id;
	}
	public void setId(int id) {
		
		this.id=id;
	}
	public String getName() {
		
		return this.name;
	}
	public void setName(String name) {
		
		this.name=name;
	}
	
    public int getAge() {
		
		return this.age;
	}
	public void setAge(int age) {
		
		this.age=age;
	}
	
	public String getPassword() {
		
		return this.password;
	}
	public void setPassword(String password) {
		
		this.password=password;
	}
	
	public String getKakuninpassword() {
		
		return this.kakuninpassword;
	}
	public void setKakuninpassword(String kakuninpassword) {
		
		this.kakuninpassword=kakuninpassword;
	}
	
	public String getKaishi() {
		
		return this.kaishi;
	}
	public void setKaishi(String kaishi) {
		
		this.kaishi=kaishi;
	}
	public String getShuryo() {
		
		return this.shuryo;
	}
	public void setShuryo(String shuryo) {
		
		this.shuryo=shuryo;
	}
	

	
}