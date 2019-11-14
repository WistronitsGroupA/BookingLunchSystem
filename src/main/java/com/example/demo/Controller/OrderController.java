package com.example.demo.Controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Orders;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

@Controller
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	// 顯示自己訂單紀錄的頁面
	@GetMapping("/selfOrderHistroy")
	public String selfOrderHistroy(Model model, HttpSession session) {
		Integer CID = (Integer) session.getAttribute("CID");
		if (CID == null) {
			model.addAttribute("text", "CID is null");
			return "redirect:/login";
		}
		// 取得資料
		List<Object[]> selfOrderHistroy = orderRepository.getSelfOrderHistroy(CID);
		// 夾帶資料
		model.addAttribute("text", "This is orderHistory");
		model.addAttribute("selfOrderHistroy", selfOrderHistroy);
		// 回傳網頁
		return "selfOrderHistroy";
	}

	// 顯示未下訂訂單的頁面
	@GetMapping("/unorderList")
	public String unorderList(Model model, HttpSession session) {
		Integer CID = (Integer) session.getAttribute("CID");
		if (CID == null) {
			model.addAttribute("text", "CID is null");
			return "redirect:/login";
		}
		// 取得資料
		List<Object[]> unorderList = orderRepository.getUnorderList();
		// 夾帶資料
		model.addAttribute("text", "This is unorderList");
		model.addAttribute("unorderList", unorderList);
		// 回傳網頁
		return "unorderList";
	}
	
	// 顯示詳細的單筆訂單
	@GetMapping("/orderDetail")
	public String orderDetail(Model model, @RequestParam("OID") Integer OID, HttpSession session) {
		Integer CID = (Integer) session.getAttribute("CID");
		if (CID == null) {
			model.addAttribute("text", "CID is null");
			return "redirect:/login";
		}
		// 取得資料
		Object order = orderRepository.getOrder(OID);
		List<Object[]> orderDetail = orderDetailRepository.getOrderDetail(OID);
		// 夾帶資料
		model.addAttribute("order", order);
		model.addAttribute("orderDetail", orderDetail);
		// 回傳網頁
		return "orderDetail";
	}

	// 新增訂單
	@PostMapping("/addOrder")
	public String addOrder(Model model, @RequestBody List<OrderDetail> orderDetail, HttpSession session) {
		Integer CID = (Integer) session.getAttribute("CID");
		if (CID == null) {
			model.addAttribute("text", "CID is null");
			return "unorderList";
		}
		Orders newOrder = new Orders();
		newOrder.setCID(CID);
		newOrder.setOrderTime(new Timestamp(new Date().getTime()));
		newOrder.setStatus(0);
		Integer newOID = orderRepository.save(newOrder).getOID();
		for (OrderDetail od : orderDetail) {
			od.setOID(newOID);
		}
		orderDetailRepository.saveAll(orderDetail);
		return "redirect:/selfOrderHistroy";
	}

	// 取消訂單
	@PostMapping("/abandonOrder")
	public String abandonOrder(Model model, @RequestBody Integer OID, HttpSession session) {
		Integer CID = (Integer) session.getAttribute("CID");
		if (CID == null) {
			model.addAttribute("text", "CID is null");
			return "redirect/login";
		}
		Orders abandonOrder = orderRepository.getOne(OID);
		if (abandonOrder == null) {
			model.addAttribute("msg", "取消訂單失敗");
		} else {
			abandonOrder.setStatus(2);
			orderRepository.save(abandonOrder);
			model.addAttribute("msg", "取消訂單成功");
		}
		return "redirect:/selfOrderHistroy";
	}

	// 下訂今日的訂單
	@PostMapping("/placeTodayOrders")
	public String placeTodayOrders(Model model, HttpSession session) {
		Integer CID = (Integer) session.getAttribute("CID");
    	if(CID == null) {
    		model.addAttribute("text", "CID is null");
    		return "redirect/login";
    	}
		Integer changes = orderRepository.placeTodayOrders();
		model.addAttribute("msg", "\"" + changes + "\"個資料行受到變動");
		return "redirect:/selfOrderHistroy";
	}
}
