package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

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
}
