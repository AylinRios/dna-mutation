package adnmutation.service;

import adnmutation.dao.HumanDAO;
import adnmutation.entity.Human;
import adnmutation.json.DnaBuild;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class HumanService {

    private final HumanDAO humanDAO;
    private final DnaService dnaService;

    public void create(final String name) {
        final Human human = humanDAO.save(new Human(name));

        int num= RandomNumber(4,8);
        final List<List<String>> dna= dnaGenerator(num);
        final boolean hasMutation = dnaService.hasMutation(dna);
        final DnaBuild dnaBuild = DnaBuild.build(dna);

        dnaService.create(dnaBuild, human, hasMutation);

        log.info("Random number: {}", num);
        log.info("DNA: {}", dna);
    }


    public int RandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public List<List<String>> dnaGenerator(int longitud) {
        final List<List<String>> dna= new ArrayList<>();

        final String dnaNitrogenousBase = "ATCG";

        for(int j = 0; j < longitud; j++) {
            List<String > adn = new ArrayList<>();
            for (int x = 0; x < longitud; x++) {
                int randomIndex = RandomNumber(0, dnaNitrogenousBase.length() - 1);
                char charsRandom = dnaNitrogenousBase.charAt(randomIndex);
                adn.add(String.valueOf(charsRandom));
            }
            dna.add(adn);
        }
        return dna;
    }

    public void validateDNA(List<List<String>> dnaData) {
        System.out.println(dnaService.hasMutation(dnaData));
    }


}
