package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VendorHistory;



@Repository
public interface VendorHistoryRepository extends JpaRepository<VendorHistory, Integer>{
	
	@Query(value = "select [dbo].[VendorHistory].[datetime], [dbo].[Vendor].[VName] from [dbo].[VendorHistory] left join [dbo].[Vendor] on [dbo].[VendorHistory].[VID]=[dbo].[Vendor].[VID]", nativeQuery = true)
	List<Object[]> finddatetimeAndVName();
}

