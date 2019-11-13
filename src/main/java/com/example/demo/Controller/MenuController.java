package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	@PostMapping("/menuController")
//    public String menu(Model model) {
//        
//        return "menu"; 
//    }
	
	@ResponseBody
	@PostMapping("/menuController")
	public Map<String,Object> map(){
		
		List<Map<String,Object>>list=jdbcTemplate.queryForList("select*from Meau");
		
		return list.get(0);
	}
	
}
