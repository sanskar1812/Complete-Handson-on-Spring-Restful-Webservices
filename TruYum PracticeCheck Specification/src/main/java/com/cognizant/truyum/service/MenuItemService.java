package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemDao dao;
	
	public List<MenuItem> getMenuItemListAdmin(){
		return dao.getMenuItemListAdmin();
	}
	
	public List<MenuItem> getMenuItemListCustomer(){
		return dao.getMenuItemListCustomer();
	}
	
	public MenuItem getMenuItem(long id) {
		return dao.getMenuItem(id);
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		dao.modifyMenuItem(menuItem);
	}

}