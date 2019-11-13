package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

	// 取得個人的訂單紀錄
	@Query(value = "SELECT [Orders].[OID], [Orders].[Order_time], SUM([OrderDetail].[Amount]*[Meau].[MPrice]) [Sum], [Orders].[Status]"
			+ "FROM [Orders] JOIN [OrderDetail] ON [Orders].[OID] = [OrderDetail].[OID]"
			+ "JOIN [Meau] ON [Meau].[MID] = [OrderDetail].[MID] Where [Orders].[CID] = ?1 "
			+ "GROUP BY [Orders].[OID], [Orders].[Order_time], [Orders].[Status]", nativeQuery = true)
	List<Object[]> getSelfOrderHistroy(Integer CID);

	// 取得未下訂的訂單
	@Query(value = "SELECT [Orders].[OID], [Customer].[CID], [Customer].[CName], SUM([OrderDetail].[Amount]*[Meau].[MPrice]) [sum], [Orders].[Order_time], [Orders].[Status]"
			+ "FROM [Orders] JOIN [OrderDetail] ON [Orders].[OID] = [OrderDetail].[OID]"
			+ "JOIN [Customer] ON [Orders].[CID] = [Customer].[CID]"
			+ "JOIN [Meau] ON [Meau].[MID] = [OrderDetail].[MID]"
			+ "GROUP BY [Orders].[OID], [Customer].[CID], [Customer].[CName], [Orders].[Order_time], [Orders].[Status]", nativeQuery = true)
	List<Object[]> getUnorderList();
}
