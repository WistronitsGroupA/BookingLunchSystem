package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TodayVendor;
import com.example.demo.entity.VendorHistory;



@Repository
public interface PurchaseRepository extends JpaRepository<TodayVendor, Integer> {
	
	//用今日訂單VID找對應店家的名稱與對應餐點
	@Query(value = "select vendor.VName, meau.* from [Lunch].[dbo].[Vendor] vendor , [Lunch].[dbo].[Meau] meau where vendor.VID = meau.VID and vendor.VID = ?1", nativeQuery = true)
	List<TodayVendor> todayMeau(int VID);
}
