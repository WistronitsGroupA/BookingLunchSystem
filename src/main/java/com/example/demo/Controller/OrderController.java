package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.OrderRepository;

@Controller
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
    @GetMapping("/selfOrderHistroy")
    public String selfOrderHistroy(Model model, HttpSession session) {
    	Integer CID = (Integer) session.getAttribute("CID");
    	if(CID == null) {
    		model.addAttribute("text", "CID is null");
    		return "selfOrderHistroy";
    	}
    	//取得資料
    	List<Object[]> selfOrderHistroy = orderRepository.getSelfOrderHistroy(CID);
        //夾帶資料
        model.addAttribute("text", "This is orderHistory");
        model.addAttribute("selfOrderHistroy", selfOrderHistroy); 
        //回傳網頁
        return "selfOrderHistroy";
    }
}
