package adnmutation.dao;

import adnmutation.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, String> {
	 Role findByName(String name);
}
