package adnmutation.dao;

import adnmutation.entity.Role;
import adnmutation.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class UserTestDAO {
    @Autowired
    private  RoleDAO roleDAO;
    @Autowired
    private UserDAO userDAO;


    @Test
    public void testSaveUser() {

        Role role = roleDAO.save(new Role("admin"));
        User user = userDAO.save(new User("AylinR", "Safe123", role));

        System.out.println("User: " + user.getUsername()+" "+user.getPassword()+" "+user.getRole() );
        Assert.assertEquals(user.getUsername(), "AylinR");
    }
}
