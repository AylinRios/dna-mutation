package adnmutation.service;

import adnmutation.dao.DnaDAO;
import adnmutation.dto.MutationDTO;
import adnmutation.dto.StatsDTO;
import adnmutation.entity.Dna;
import adnmutation.entity.Human;
import adnmutation.json.DnaBuild;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class DnaService {
    final private DnaDAO dnaDAO;
    ModelMapper modelMapper = new ModelMapper();

    public void create(DnaBuild adn, Human human){
        final Dna dna = dnaDAO.save( new Dna(adn, human, false));
    }

    public StatsDTO getDnaStats(){
        float countMutations = dnaDAO.countByHasMutation(true);
        float countNotMutation = dnaDAO.countByHasMutation(false);

        StatsDTO statsDTO = StatsDTO.build(countMutations, countNotMutation, countNotMutation == 0 ? (countMutations == 0 ? 0 : 1) : countMutations / countNotMutation);

        return statsDTO;
    }

    public List<MutationDTO> mutationAccounting( boolean hasMutation) {

        List<MutationDTO> mutationDTO;

        if (hasMutation == true) {
             mutationDTO = dnaDAO.dnaData(true).stream().map(mutationProjection -> modelMapper.map(mutationProjection, MutationDTO.class)).collect(Collectors.toList());
        } else{
            mutationDTO = dnaDAO.dnaData(false).stream().map(mutationProjection -> modelMapper.map(mutationProjection, MutationDTO.class)).collect(Collectors.toList());
        }

         return mutationDTO;
    }

    public List<MutationDTO> records(){
        List<MutationDTO> mutationDTO = dnaDAO.recordsData().stream().map(mutationProjection -> modelMapper.map(mutationProjection, MutationDTO.class)).collect(Collectors.toList());

        return mutationDTO;

    }


}
