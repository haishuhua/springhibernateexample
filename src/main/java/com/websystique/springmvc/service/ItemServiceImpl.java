package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ItemDao;
import com.websystique.springmvc.model.Item;

@Service("ItemService")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao dao;
	
	public Item findById(int id) {
		return dao.findById(id);
	}

	public void saveItem(Item Item) {
		dao.saveItem(Item);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateItem(Item Item) {
		Item entity = dao.findById(Item.getId());
		if(entity!=null){
			entity.setName(Item.getName());
			entity.setPrice(Item.getPrice());
			entity.setImgLink(Item.getImgLink());
		}
	}

	public void deleteItemByName(String name) {
		dao.deleteItemByName(name);
	}
	
	public List<Item> findAllItems() {
		return dao.findAllItems();
	}

	public Item findItemByName(String name) {
		return dao.findItemByName(name);
	}

	public boolean isItemNameUnique(Integer id, String name) {
		Item Item = findItemByName(name);
		return ( Item == null || ((id != null) && (Item.getId() == id)));
	}

	
}
