package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyContoroller002 {
	
	@RequestMapping("/Mainmenyu")
	public String Mainmenyu() {
		
		return "Mainmenyu";
		
	}
	
	@RequestMapping("/header")
	public String header() {
		
		return "header";
	}
	
	//@RequestMapping("/Session")
//	public String Session() {
//		
//		return "Session";
//	}
	
//	public String day(Model m,
//			@RequestParam("formatNowDate1")String formatNowDate1
//			
//					
//				) {
//
//		
//	
//			
//			LocalDateTime newDate=LocalDateTime.now();
//			DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//			String formatNowDate11=dtf1.format(newDate);
//			m.addAttribute("formatNowDate",formatNowDate11);
//			return formatNowDate11;
//		
//		
//	}

}
