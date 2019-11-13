package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @GetMapping("/hello")
    public String hello(Model model) {
    	//我要帶的資料
        //model.addAttribute("text", "Hello World!!");
        //要回傳的網頁
        return "hello"; // resources/hello.html
    }
	
	@GetMapping("/menu")
    public String menu(Model model) {
        
        return "menu";
    }
	
	@ResponseBody
	@GetMapping("/menuQuery")
	public Map<String,Object> map(){
		
		List<Map<String,Object>>list=jdbcTemplate.queryForList("select*from Meau");
		
		return list.get(0);
		
	}
}
