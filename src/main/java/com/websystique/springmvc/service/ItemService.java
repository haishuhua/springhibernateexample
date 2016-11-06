package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Item;

public interface ItemService {

	Item findById(int id);
	
	void saveItem(Item Item);
	
	void updateItem(Item Item);
	
	void deleteItemByName(String name);

	List<Item> findAllItems(); 
	
	Item findItemByName(String name);

	boolean isItemNameUnique(Integer id, String name);
	
}
