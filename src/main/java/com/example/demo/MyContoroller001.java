package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;
import java.util.regex.*;


@Controller

public class MyContoroller001 {
	
	@Autowired

	private KaihatuService service;
	//入力画面表示
	@RequestMapping("/nyuryoku")
	public String nyuryoku() {
		
		return "nyuryoku";
		
		
		
	}
	
	@GetMapping("/kakunin")
	public String kakunin(Model m,
			@RequestParam("password")String password) {
		
		return "nyuryoku";
	}
	
		
		
	//入力画面確認ボタン
	@PostMapping("/kakunin")
	public String kakunin( Model m,
		@RequestParam("id")String id,
		@RequestParam("name")String name,
		@RequestParam("age")String age,
		@RequestParam("password")String password,
		@RequestParam("kakuninpassword")String kakuninpassword,
		@RequestParam("kaishi")String kaishi,
		@RequestParam("shuryo")String shuryo
				
			){
		
		int numId=Integer.parseInt(id);
		
		

		List<Entity>entity=service.selectById(numId);
		if(entity.size()==0) {
			
			entity=null;
			m.addAttribute("errrecord",entity);
			m.addAttribute("errrecord1","一致するレコードがありません");
			return "nyuryoku";
		}

		if(id==null) {
		
			
			return "nyuryoku";}
		if(name==null) {
			
			return "nyuryoku";}
		if(password==null) {
			
			return "nyuryoku";}
		if(password.length()<=7) {
			m.addAttribute("errPasswordLength","8文字以上で入力してください");
			return "nyuryoku";}
		if(!(kakuninpassword.equals(password))) {
			m.addAttribute("errKakuninPassword","パスワードと一致していません");
			return "nyuryoku";}
			
				
				
				String[] array= {password};
				String pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";
				Pattern p=Pattern.compile(pattern);
				//Pattern p1=Pattern.compile("[A-Z]");
			//
				//変数にarrayのようそを一つずつ格納してる
				for(String passworderr:array) {
					
					if(!(p.matcher(passworderr).find())) {
						
						m.addAttribute("errPassword"," 英数含む大文字1文字以上で入力してください");
						return "nyuryoku";}
					
					
				}	
				
			
	 
		//if(!(password==pattern)) {
			//m.addAttribute("errPassword"," 英数含む大文字1文字以上で入力してください");
			//return "nyuryoku";
			
			
		//}
		
		m.addAttribute("id",id);
		m.addAttribute("name",name);
		m.addAttribute("age",age);
		m.addAttribute("password",password);
		m.addAttribute("kakuninpassword",kakuninpassword);
		m.addAttribute("kaishi",kaishi);
		m.addAttribute("shuryo",shuryo);
		
		return "kakunin";
		
		
		
		
	}
	
	
	
		//確認画面（更新、戻る分岐）
	@PostMapping("/kakunin2")
	public String  kakunin2(Model m,
			
			@RequestParam("id")String id,
			@RequestParam("name")String name,
			@RequestParam("age")String age,
			@RequestParam("password")String password,
			@RequestParam("kakuninpassword")String kakuninpassword,
			@RequestParam("kaishi")String kaishi,
			@RequestParam("shuryo")String shuryo,
			@RequestParam("kakunin2")String kakunin2
			
			) {
		
			
			switch(kakunin2) {
			case "更新":
				//更新ボタン
				
				
				int numId=Integer.parseInt(id);
				int numAge=Integer.parseInt(age);
			
				
//				
//				List<Entity>entity=service.selectById(numId);
//				if(entity.size()==0) {
//					
//					entity=null;
//					m.addAttribute("errrecord",entity);
//					m.addAttribute("errrecord1","一致するレコードがありません");
//					return "nyuryoku";
//				}

				
				Entity entity=new Entity(numId,name,numAge,password,kakuninpassword,kaishi,shuryo);
				m.addAttribute("id",numId);
				m.addAttribute("name",name);
				m.addAttribute("age",numAge);
				m.addAttribute("password",password);
				m.addAttribute("kakuninpassword",kakuninpassword);
				m.addAttribute("kaishi",kaishi);
				m.addAttribute("shuryo",shuryo);
				
				
				service.update(entity);
				
				return "kanryou";
				
				
			case "戻る":
				//戻るボタン
				
				int numId2=Integer.parseInt(id);
				int numAge2=Integer.parseInt(age);
				   m.addAttribute("id",numId2);
					m.addAttribute("name",name);
					m.addAttribute("age",numAge2);
					m.addAttribute("password",password);
					m.addAttribute("kakuninpassword",kakuninpassword);
					m.addAttribute("kaishi",kaishi);
					m.addAttribute("shuryo",shuryo);
					
					return "nyuryoku";}
			return kakunin2;
			
			
			
				
		 
			
			
		  
		
		}
	@PostMapping("/menu")
	public String menu(Model m) {
		
		return "Mainmenyu" ;
		
	}
	






}
	
	
	
	
	


