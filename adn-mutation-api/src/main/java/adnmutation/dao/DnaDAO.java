package adnmutation.dao;

import adnmutation.entity.Dna;
import adnmutation.projection.MutationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DnaDAO extends JpaRepository<Dna, String> {
    float countByHasMutation(boolean mutation);

    @Query(value = "SELECT  h.name , h.created_at as createdAt , d.has_mutation as hasMutation FROM dna d JOIN human h where d.human_id = h.id and d.has_mutation = ?1", nativeQuery = true)
    List<MutationProjection> dnaData(boolean haveMutation);

    @Query(value = "SELECT  h.name , h.created_at as createdAt , d.has_mutation as hasMutation FROM dna d JOIN human h where d.human_id = h.id", nativeQuery = true)
    List<MutationProjection> recordsData();

}
