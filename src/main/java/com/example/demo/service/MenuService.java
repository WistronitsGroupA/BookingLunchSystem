package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.hibernate.query.QueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Menu;

@Service
public class MenuService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	DataSource dataSource;
	
	public Menu getMenu(Integer mid) {
		    try {
				return ((Collection<Menu>) jdbcTemplate).stream()
				        .filter(p -> p.getMID().equals(mid))
				        .findFirst()
				        .orElseThrow(() -> new NotFoundException());
			} catch (NotFoundException e) {
				e.printStackTrace();
				return null;
			}
		
//		try {
//			return ((Collection<Menu>) dataSource).stream()
//			        .filter(p -> p.getMID().equals(mid))
//			        .findFirst()
//			        .orElseThrow(() -> new NotFoundException());
//		} catch (NotFoundException e) {
//			e.printStackTrace();
//			return null;
//		}
		
	}

	//不用新增產品
	public Menu createMenu(Menu request) {
	    return null;
	}

	public Menu replaceMenu(Integer mid, Menu request) {
	    return null;
	}

	public void deleteMenu(Integer mid) {
	    
	}
	public List<Menu> getMenus(QueryParameter param) {
		Stream<Menu>stream=((Collection<Menu>) jdbcTemplate).stream();
		
//		if((param.getKeyword()!=null) {
//			stream=stream.filter(p->p.getMName().contains(param.getKeyword()));
//		}
		
		
		
	    return null;
	}
}
