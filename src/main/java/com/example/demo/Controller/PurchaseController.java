package com.example.demo.Controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.entity.TodayVendor;
import com.example.demo.entity.Vendor;
import com.example.demo.entity.VendorHistory;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.VendorHistoryRepository;
import com.example.demo.repository.VendorRepository;

@Controller
public class PurchaseController {
	
	@Autowired
	VendorRepository vendorRepository;
	@Autowired
	VendorHistoryRepository vendorHistoryRepository;	
	@Autowired
	PurchaseRepository purchaseRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	//用來判斷session是否超過時間
	private boolean checkSession(HttpSession session) {
		if(session.getAttribute("userId") == null || "".equals(session.getAttribute("userId"))) {
			return true;
		}
		return false;
	}
	
	@GetMapping("/todayPurchase")
	public String todayPurchase(Model model, HttpSession session) {
		if(checkSession(session)) {
			model.addAttribute("msg", "操作時間過久，請重新登入!");
			return "login";
		}
		//抓取今天日期判斷今天是否已開啟揪團
		Date dNow = new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		VendorHistory todayVendor = vendorHistoryRepository.searchHistory(df.format(dNow));
//		//如果今日未開團&權限是揪團人
		if(todayVendor == null && Integer.parseInt(session.getAttribute("power").toString()) == 2) {
			return "redirect:/chooseToday";
		}
		if(todayVendor != null) {
			List<TodayVendor> meau = purchaseRepository.todayMeau(todayVendor.getVID());
			model.addAttribute("meau", meau);
		}
		return "todayMeau";
	}
	//呈現選擇店家頁面
	@GetMapping("/chooseToday")
	public String chooseToday(Model model, HttpSession session) {
		if(checkSession(session)) {
			model.addAttribute("msg", "操作時間過久，請重新登入!");
			return "login";
		}
		List<Vendor> vendor = null;
		//抓取今天日期判斷今天是否已開啟揪團
		Date dNow = new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		VendorHistory todayVendor = vendorHistoryRepository.searchHistory(df.format(dNow));
		if(todayVendor == null) {
			vendor = vendorRepository.findAll();
		}else {
			model.addAttribute("err", "今日店家已選擇");
		}
	
		model.addAttribute("vendor", vendor);
		return "chooseVendor";
	}
	//新增店家紀錄,成功導訂購畫面,失敗返回
	@PostMapping("/insertToday")
	public String insertToday(Model model, HttpSession session, @RequestParam("VID") String VID) {
		if(checkSession(session)) {
			model.addAttribute("msg", "操作時間過久，請重新登入!");
			return "login";
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String today = df.format(new java.util.Date());
		VendorHistory todayVendor = vendorHistoryRepository.searchHistory(today);
		Optional<Vendor> vendor = vendorRepository.findById(Integer.parseInt(VID));
		if(vendor != null && todayVendor == null) {
			todayVendor = new VendorHistory();
			todayVendor.setVID(vendor.get().getVID());
			todayVendor.setCID((Integer)session.getAttribute("CID"));
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd hh:mm:ss");
			todayVendor.setdatetime(new Timestamp(new Date().getTime()));
			
			vendorHistoryRepository.save(todayVendor);
			return "redirect:/checkToday";
		}else if(vendor != null && todayVendor != null){
			model.addAttribute("msg", "選擇店家失敗,今天店家已經選擇");
			return "chooseVendor";
		}else {
			model.addAttribute("msg", "選擇店家失敗");
			return "chooseVendor";
		}
	}
	//進入團購畫面判斷是否已選擇今日店家
	@RequestMapping(value = "/checkToday", method = { RequestMethod.POST, RequestMethod.GET })
	public String checkToday(Model model, HttpSession session) {
		if(checkSession(session)) {
			model.addAttribute("msg", "操作時間過久，請重新登入!");
			return "login";
		}
		String msg = null;
		List<TodayVendor> meau = null;
		//取得今天日期判斷今天是否選擇店家
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
		VendorHistory today = vendorHistoryRepository.searchHistory(ft.format(dNow));
		if(today != null) {
			meau = purchaseRepository.todayMeau(today.getVID());
		}else {
			msg = "尚未選擇今日店家";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("meau", meau);
		return "todayMeau";
	}
}
