package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Item;

public interface ItemDao {

	Item findById(int id);

	void saveItem(Item Item);
	
	void deleteItemByName(String name);
	
	List<Item> findAllItems();

	Item findItemByName(String name);

}
