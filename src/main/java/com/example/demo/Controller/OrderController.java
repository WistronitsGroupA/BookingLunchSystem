package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/selfOrderHistroy")
    public String selfOrderHistroy(Model model) {
    	//取得資料
        ArrayList<Object> selfOrderHistroy = new ArrayList<Object>();
        selfOrderHistroy.add(new Object() {String cname = "123"; int sum = 100;Date datetime = new Date();int status = 1;});
        selfOrderHistroy.add(new Object() {String cname = "456"; int sum = 120;Date datetime = new Date();int status = 2;});
        //夾帶資料
        model.addAttribute("text", "This is orderHistory");
        model.addAttribute("selfOrderHistroy", selfOrderHistroy);
        //回傳網頁
        return "selfOrderHistroy";
    }
}
