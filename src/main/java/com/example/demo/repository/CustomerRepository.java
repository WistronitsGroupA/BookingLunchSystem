package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	//判斷是否有該帳號密碼
	@Query(value = "select * from [Lunch].[dbo].[Customer] where account = ?1 and password = ?2", nativeQuery = true)
	Customer checkLogin(String account, String password);
}
