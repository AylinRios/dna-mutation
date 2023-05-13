package adnmutation.dao;

import adnmutation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserDAO extends JpaRepository<User, String> {
    Optional<User> findUserByUsername(String username);

    boolean existsByUsername(String username);

}
