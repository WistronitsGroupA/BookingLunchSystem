package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VendorHistory;

@Repository
public interface VendorHistoryRepository extends JpaRepository<VendorHistory, Integer> {
	// 查詢店家紀錄是否有開啟今日訂單
	@Query(value = "select * from [Lunch].[dbo].[VendorHistory] where convert(varchar, datetime, 111) = ?1", nativeQuery = true)
	VendorHistory searchHistory(String datetime);
}
