package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		return "login";
	}
	
	//檢核是否登入成功
	@PostMapping("/checkLogin")
	public String checkLogin(Model model, @RequestParam("account") String account, @RequestParam("password") String password, HttpSession session, HttpServletRequest request) {
		Customer check = customerRepository.checkLogin(account, password);
		if(check != null) {
			session.setAttribute("CID", check.getCID());
			session.setAttribute("userId", check.getAccount());
			session.setAttribute("power", check.getPower());
			return "redirect:/todayPurchase";
		}else {
			request.setAttribute("msg", "帳號或密碼輸入錯誤");
		}
		return "login";
	}
	
	//登出清除帳號session
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.removeAttribute("user");
		}
		
		return "redirect:/login";
	}
}