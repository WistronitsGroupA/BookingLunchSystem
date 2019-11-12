package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	//呈現登入頁面
	@GetMapping("/login")
	public String loginPage(Model model) {
		List<Customer> all = customerRepository.findAll();
		model.addAttribute("cus", all);
		return "login";
	}
	
	//檢核是否登入成功
	@PostMapping("/checkLogin")
	public String checkLogin(Model model, @RequestParam("account") String account, @RequestParam("password") String password) {
		Customer check = customerRepository.checkLogin(account, password);
		if(check != null) {
			return "hello";
		}
		return "login";
	}
}
