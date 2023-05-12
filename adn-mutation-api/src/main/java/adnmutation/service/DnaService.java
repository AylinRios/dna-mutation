package adnmutation.service;

import adnmutation.dao.DnaDAO;
import adnmutation.dto.StatsDTO;
import adnmutation.entity.Dna;
import adnmutation.entity.Human;
import adnmutation.json.DnaBuild;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class DnaService {
    final private DnaDAO dnaDAO;

    public void create(DnaBuild adn, Human human){
        final Dna dna = dnaDAO.save( new Dna(adn, human));
    }

    public StatsDTO getDnaStats(){
        float countMutations = dnaDAO.countByHasMuation(true);
        float countNotMutation = dnaDAO.countByHasMuation(false);

        StatsDTO statsDTO = StatsDTO.build(countMutations, countNotMutation, countNotMutation == 0 ? (countMutations == 0 ? 0 : 1) : countMutations / countNotMutation);

        return statsDTO;
    }

}
