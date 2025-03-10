package com.example.demo;
import lombok.Data;


@Data
public class Entity{
	

	private int id;
	private String name;
	private int age;
	
	//@NotBlank
	//@Pattern(regexp="^(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9_]{8,24}+$")
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
	public String setName(String name) {
		
		return this.name=name;
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
	public String setPassword(String password) {
		
		return this.password=password;
	}
	
	public String getKakuninpassword() {
		
		return this.kakuninpassword;
	}
	public String setKakuninpassword(String kakuninpassword) {
		
		return this.kakuninpassword=kakuninpassword;
	}
	
	public String getKaishi() {
		
		return this.kaishi;
	}
	public String setKaishi(String kaishi) {
		
		return this.kaishi=kaishi;
	}
	public String getShuryo() {
		
		return this.shuryo;
	}
	public String setShuryo(String shuryo) {
		
		return this.shuryo=shuryo;
	}
}
	
	

	