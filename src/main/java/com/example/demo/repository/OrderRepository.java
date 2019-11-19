package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

	// 取得個人的訂單紀錄
	@Query(value = "SELECT [Orders].[OID], [Orders].[OrderTime], SUM([OrderDetail].[Amount]*[Meau].[MPrice]) [Sum], [Orders].[Status]"
			+ "FROM [Orders] JOIN [OrderDetail] ON [Orders].[OID] = [OrderDetail].[OID]"
			+ "JOIN [Meau] ON [Meau].[MID] = [OrderDetail].[MID] Where [Orders].[CID] = ?1 "
			+ "GROUP BY [Orders].[OID], [Orders].[OrderTime], [Orders].[Status]", nativeQuery = true)
	List<Object[]> getSelfOrderHistroy(Integer CID);

	// 取得未下訂的訂單
	@Query(value = "SELECT [Orders].[OID], [Customer].[CID], [Customer].[CName], SUM([OrderDetail].[Amount]*[Meau].[MPrice]) [sum], [Orders].[OrderTime], [Orders].[Status]"
			+ "FROM [Orders] LEFT JOIN [OrderDetail] ON [Orders].[OID] = [OrderDetail].[OID]"
			+ "LEFT JOIN [Customer] ON [Orders].[CID] = [Customer].[CID]"
			+ "LEFT JOIN [Meau] ON [Meau].[MID] = [OrderDetail].[MID]"
			+ "WHERE [Status] = 0 "
			+ "GROUP BY [Orders].[OID], [Customer].[CID], [Customer].[CName], [Orders].[OrderTime], [Orders].[Status]", nativeQuery = true)
	List<Object[]> getUnorderList();
	
	@Query(value = "select sum(tab.sum1) as cost \r\n" + 
			"from (SELECT SUM([OrderDetail].[Amount]*[Meau].[MPrice])as sum1\r\n" + 
			"			FROM [Orders] LEFT JOIN [OrderDetail] ON [Orders].[OID] = [OrderDetail].[OID]\r\n" + 
			"			LEFT JOIN [Customer] ON [Orders].[CID] = [Customer].[CID]\r\n" + 
			"			LEFT JOIN [Meau] ON [Meau].[MID] = [OrderDetail].[MID]\r\n" + 
			"			WHERE [Status] = 0 \r\n" + 
			"			GROUP BY [Orders].[OID], [Customer].[CID], [Customer].[CName], [Orders].[OrderTime], [Orders].[Status]) as tab", nativeQuery = true)
	Integer getTotalcost();
	
	// 下訂今日的訂單
	@Transactional
	@Modifying
	@Query(value = "UPDATE [Orders] " + 
			"SET [Status] = 1 " + 
			"WHERE CAST([Orders].[OrderTime] as DATE) = CONVERT (date, GETDATE()) and [Status] = 0", nativeQuery = true)
	Integer placeTodayOrders();
	
	// 取得詳細的單筆訂單
	@Query(value = "SELECT [Orders].[OID],[Customer].[CName],[OrderTime],[Status],sum([Amount]*[MPrice]) total " + 
			"FROM [Orders] JOIN [OrderDetail] ON [Orders].[OID] = [OrderDetail].[OID] " + 
			"JOIN [Customer] ON [Orders].[CID] = [Customer].[CID] " + 
			"JOIN [Meau] ON [OrderDetail].[MID] = [Meau].[MID] " + 
			"WHERE [Orders].[OID] = ?1 " + 
			"GROUP BY [Orders].[OID],[Customer].[CName],[OrderTime],[Status]", nativeQuery = true)
	Object[] getOrder(Integer OID);
}
