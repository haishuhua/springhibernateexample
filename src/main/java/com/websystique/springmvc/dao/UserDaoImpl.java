package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> {

	public User findById(int id) {
		return getByKey(id);
	}

	public void saveUser(User user) {
		persist(user);
	}

//	public void deleteUserBySsn(String ssn) {
//		Query query = getSession().createSQLQuery("delete from User where ssn = :ssn");
//		query.setString("ssn", ssn);
//		query.executeUpdate();
//	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	public User findUserBywechatnumber(String wechatnumber) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("wechatnumber", wechatnumber));
		return (User) criteria.uniqueResult();
	}
	
	
}
