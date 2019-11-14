package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.OrderDetailPK;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
	// 取得詳細的單筆訂單明細
	@Query(value = "SELECT [OrderDetail].[MID],[Pic],[MName],[MPrice],[Amount],[MPrice]*[Amount] subtotal " + 
			"FROM [OrderDetail] JOIN [Meau] ON [OrderDetail].[MID] = [Meau].[MID] " + 
			"WHERE [OID] = ?1", nativeQuery = true)
	List<Object[]> getOrderDetail(Integer OID);
}
