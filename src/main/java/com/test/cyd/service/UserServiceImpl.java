package com.test.cyd.service;

import com.test.cyd.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl {

  @Autowired
  private SessionFactory sessionFactory;

  public User findByUsername(String username) {
    return (User) sessionFactory.getCurrentSession().get(User.class, username);
  }

  @Transactional(readOnly = false)
  public void saveUser(User user) {
    sessionFactory.getCurrentSession().saveOrUpdate(user);
  }

  @Transactional(readOnly = false)
  public void deleteUser(String userName) {
    User user = (User) sessionFactory.getCurrentSession().get(User.class, userName);
    if (user != null) {
      sessionFactory.getCurrentSession().delete(user);
    }
  }

  public List<User> findUsers(String username) {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
    criteria.add(Restrictions.like(User.USERNAME, username, MatchMode.START));
    return criteria.list();
  }

  public List<User> getAllUsers() {
    return sessionFactory.getCurrentSession().createCriteria(User.class).list();
  }
}
