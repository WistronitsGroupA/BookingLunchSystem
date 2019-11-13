package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	DataSource dataSource;
	
	//資料庫可連線
	@Test
	public void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());
		
		Connection connection=dataSource.getConnection();
		System.out.println(connection);
		
		connection.close();
	}

}
