package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.entity.VendorHistory;
import com.example.demo.repository.VendorHistoryRepository;

@Controller
public class VenderHistoryController {
	@Autowired
	VendorHistoryRepository vendorhistoryRepository;
	
    @GetMapping("/VH")
    public String VH(Model model, VendorHistory vendorhistory) {

    List<Object[]> dataList = vendorhistoryRepository.finddatetimeAndVName();
        model.addAttribute("vendorhistory", dataList);
        
        return "VendorHistory";
        
    }
}
