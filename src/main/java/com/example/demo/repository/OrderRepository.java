package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	//
	@Query(value = "SELECT [Orders].[OID], [Orders].[Order_time], SUM([OrderDetail].[Amount]*[Meau].[MPrice]) [Sum], [Orders].[Status]" + 
			"FROM [Orders] JOIN [OrderDetail] ON [Orders].[OID] = [OrderDetail].[OID]" + 
			"JOIN [Meau] ON [Meau].[MID] = [OrderDetail].[MID]" + 
			"Where [Orders].[CID] = 2" + 
			"GROUP BY [Orders].[OID], [Orders].[Order_time], [Orders].[Status]" + 
			"", nativeQuery = true)
	List<Object[]> getSelfOrderHistroy();
}
