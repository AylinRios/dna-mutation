package adnmutation.dao;

import adnmutation.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanDAO extends JpaRepository<Human, String> {}
