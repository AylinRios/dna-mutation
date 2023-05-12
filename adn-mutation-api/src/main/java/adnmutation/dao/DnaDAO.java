package adnmutation.dao;

import adnmutation.entity.Dna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnaDAO extends JpaRepository<Dna, String> {
    float countByHasMuation(boolean mutation);
}
