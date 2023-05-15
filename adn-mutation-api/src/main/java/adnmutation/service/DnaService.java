package adnmutation.service;

import adnmutation.dao.DnaDAO;
import adnmutation.dto.MutationDTO;
import adnmutation.dto.StatsDTO;
import adnmutation.entity.Dna;
import adnmutation.entity.Human;
import adnmutation.json.DnaBuild;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class DnaService {

    final private List<String> series = Arrays.asList("AAAA", "TTTT", "GGGG", "CCCC");
    final private DnaDAO dnaDAO;
    ModelMapper modelMapper = new ModelMapper();

    public void create(DnaBuild adn, Human human, boolean hasMutation) {
        dnaDAO.save( new Dna(adn, human, hasMutation));
    }

    public StatsDTO getDnaStats() {
        float countMutations = dnaDAO.countByHasMutation(true);
        float countNotMutation = dnaDAO.countByHasMutation(false);

        return StatsDTO.build(countMutations, countNotMutation, countNotMutation == 0 ? (countMutations == 0 ? 0 : 1) : countMutations / countNotMutation);
    }

    public List<MutationDTO> mutationAccounting( boolean hasMutation) {
        return dnaDAO.dnaData(hasMutation).stream().map(mutationProjection -> modelMapper.map(mutationProjection, MutationDTO.class)).collect(Collectors.toList());
    }

    public List<MutationDTO> records() {
        return dnaDAO.recordsData().stream().map(mutationProjection -> modelMapper.map(mutationProjection, MutationDTO.class)).collect(Collectors.toList());
    }

    public boolean hasMutation(List<List<String>> humanDNA) {
        int counter = 0;

        System.out.println("=================   Original  =================");
        humanDNA.forEach(System.out::println);

        System.out.println("=================   Horizontal  =================");
        counter += validateHorizontalMutation(humanDNA);

        if (counter < 2) {
            System.out.println("=================  Vertical  =================");
            counter += validateVerticalMutation(humanDNA);
        }

        if (counter < 2){
            System.out.println("=================== Diagonal   ===============");
            counter += validateDiagonalMutation(humanDNA);
        }
        if (counter < 2){
            System.out.println("=================== Diagonal reversed  ===============");
            counter += validateDiagonalMutation(reversedDiagonal(humanDNA));
        }

        System.out.println("======= FINAL COUNTER =====" + "\n"+ counter);
        return counter >= 2;
    }

    private int validateHorizontalMutation(List<List<String>> humanDNA) {
        final CounterHolder counterHolder = new CounterHolder();

        humanDNA.stream().collect(Collectors.toList()).forEach(row -> {
            if (counterHolder.getCounter() < 2)
                counterHolder.addValue(this.validateTotalMutation(row));
            return; // Exits the foreach to ignore the rest of the series as there are 2 series already.
        });
        System.out.println(counterHolder.getCounter());
        return counterHolder.getCounter();
    }

    private int validateVerticalMutation(List<List<String>> humanDNA) {
        final CounterHolder counterHolder = new CounterHolder();
        for (int row = 0; row < humanDNA.size(); row++ ) {
            List<String> verticalLines = new ArrayList<>();
            for (int column = 0; column < humanDNA.get(row).size(); column++) {
                verticalLines.add(humanDNA.get(column).get(row));
            }
            if (counterHolder.getCounter() < 2)
                counterHolder.addValue(this.validateTotalMutation(verticalLines));
        }
        System.out.println(counterHolder.getCounter());
        return counterHolder.getCounter();
    }

    private int validateDiagonalMutation(List<List<String>> humanDNA) {
        List<List<String>> diagonalLines = new ArrayList<>();
        final CounterHolder counterHolder = new CounterHolder();

        for (int row = 0; row < humanDNA.size(); row++) {
            List<String> diagonalElements = new ArrayList<>();

                int column2 = row, row2 = 0;
                while (row2 <= row) {
                    diagonalElements.add(humanDNA.get(row2).get(column2));
                    column2--;
                    row2++;
                }
            diagonalLines.add(diagonalElements);
        }

        for (int row = humanDNA.size() - 1; row > 0; row--) {
            List<String> diagonalElements = new ArrayList<>();

            int column2 = row, row2 = humanDNA.size() - 1;
            while (column2 <= humanDNA.size() - 1) {
                diagonalElements.add(0,humanDNA.get(row2).get(column2));
                column2++;
                row2--;
            }
            diagonalLines.add(humanDNA.size(),diagonalElements);
        }
        diagonalLines.forEach(line -> {
            if (counterHolder.getCounter() < 2)
                counterHolder.addValue(this.validateTotalMutation(line));
        });
        System.out.println(counterHolder.getCounter());
        return counterHolder.getCounter();
    }

    public List<List<String>> reversedDiagonal(List<List<String>> humanDNA){
        List<List<String>> invertedDiagonal= new ArrayList<>();

        humanDNA.forEach(element-> {
            List<String> newList = new ArrayList<>();
            element.forEach(item -> {
                newList.add(0, item);
            });
            invertedDiagonal.add(newList);
        });
        return invertedDiagonal;
    }

    public int validateTotalMutation(List<String> ADNSerie) {
        final CounterHolder counterHolder = new CounterHolder();

        if(ADNSerie.size() < 4) {
            System.out.println("Total sequence found: " + counterHolder.getCounter());
            return counterHolder.getCounter();
        }

        String text = ADNSerie.stream().collect(Collectors.joining(""));
        series.forEach(item -> counterHolder.addValue(StringUtils.countOccurrencesOf(text, item)));
        System.out.println("Total sequence found: " + counterHolder.getCounter());
        return counterHolder.getCounter();

    }

}

@Setter
@Getter
class CounterHolder {
    private int counter;

    public void addValue(int newValue) {
        counter += newValue;
    }
}
