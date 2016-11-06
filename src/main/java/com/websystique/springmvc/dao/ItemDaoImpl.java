package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Item;

@Repository("ItemDao")
public class ItemDaoImpl extends AbstractDao<Integer, Item> implements ItemDao {

	public Item findById(int id) {
		return getByKey(id);
	}

	public void saveItem(Item Item) {
		persist(Item);
	}

	public void deleteItemByName(String Name) {
		Query query = getSession().createSQLQuery("delete from Item where name = :Name");
		query.setString("name", Name);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Item> findAllItems() {
		Criteria criteria = createEntityCriteria();
		return (List<Item>) criteria.list();
	}

	public Item findItemByName(String Name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", Name));
		return (Item) criteria.uniqueResult();
	}

}
