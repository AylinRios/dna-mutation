package adnmutation.dao;

import adnmutation.entity.User;
import adnmutation.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDAO extends JpaRepository<UserInfo, String> {
    UserInfo findByUser(User user);

}

