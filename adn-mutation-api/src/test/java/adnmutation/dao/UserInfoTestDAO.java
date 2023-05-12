package adnmutation.dao;

import adnmutation.entity.Role;
import adnmutation.entity.User;
import adnmutation.entity.UserInfo;
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
public class UserInfoTestDAO {
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Test
    public void testSaveUserInfo() {

        Role role = roleDAO.save(new Role("admin"));
        User user = userDAO.save(new User("IngridM", "123Safe", role));
        UserInfo userInfo= userInfoDAO.save(new UserInfo("Ingrid", "Ríos","Mendez","ingrid@gmail.com", "",user));

        log.info("User info: " + userInfo.getName()+" "+userInfo.getPaternalName()+" "+userInfo.getMaternalName()+" "+userInfo.getEmail()+" "+userInfo.getBirthday());
        Assert.assertEquals(userInfo.getName(), "Ingrid");
    }
}
