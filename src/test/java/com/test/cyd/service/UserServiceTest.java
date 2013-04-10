package com.test.cyd.service;

import com.test.cyd.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class UserServiceTest {

  @Autowired
  private UserServiceImpl userService;

  private User createUser(String username, String firstname, String lastname) {
    User user = new User(username, firstname, lastname);
    user.setCreatedDate(new Date());
    userService.saveUser(user);
    return user;
  }

  @Test
  public void testSaveUser() throws Exception {
    User user = createUser("user_A", "first_A", "last_A");
    User found = userService.findByUsername(user.getUsername());
    Assert.assertEquals(user, found);
  }

  @Test
  public void testSearchUser() throws Exception {
    String username = "user_B";
    createUser(username, "first_B", "last_B");
    List<User> users = userService.findUsers(username);
    Assert.assertEquals(1, users.size());
    Assert.assertEquals(username, users.iterator().next().getUsername());
  }

  @Test
  public void testDeleteUser() throws Exception {
    String username = "user_C";
    createUser(username, "first_C", "last_C");
    Assert.assertNotNull(userService.findByUsername(username));
    userService.deleteUser(username);
    Assert.assertNull(userService.findByUsername(username));
  }

  @Test
  public void testUpdateUser() throws Exception {
    String username = "user_D";
    String firstname = "first_D";
    String lastname = "last_D";
    Assert.assertNull(userService.findByUsername(username));
    createUser(username, firstname, lastname);
    User user_1 = userService.findByUsername(username);
    Assert.assertNotNull(user_1);
    Assert.assertEquals(firstname, user_1.getFirstname());
    Assert.assertEquals(lastname, user_1.getLastname());

    String otherfirstname = "other_first_D";
    String otherlastname = "other_last_D";
    user_1.setFirstname(otherfirstname);
    user_1.setLastname(otherlastname);
    userService.saveUser(user_1);

    User found = userService.findByUsername(username);
    Assert.assertNotNull(found);
    Assert.assertEquals(otherfirstname, found.getFirstname());
    Assert.assertEquals(otherlastname, found.getLastname());
  }
}
