package adnmutation.dao;

import adnmutation.entity.Role;
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
public class RoleTestDAO {
    @Autowired
    private RoleDAO roleDAO;

    @Test
    public void testSaveRole() {

        Role role = roleDAO.save(new Role("admin"));

        System.out.println("Role: " + role.getName());
        Assert.assertEquals(role.getName(), "admin");
    }
}
