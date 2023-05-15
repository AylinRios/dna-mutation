package adnmutation.controller;

import adnmutation.form.DNADataForm;
import adnmutation.service.DnaService;
import adnmutation.service.HumanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/human")
public class HumanController {

    private final HumanService humanService;
    private final DnaService dnaService;
    @PostMapping("/{name}")
    public ResponseEntity<Void> create(@PathVariable String name){

        humanService.create(name);

        return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).build();
    }

    @PostMapping("/mutation")
    public ResponseEntity<Void> hasMutation(@RequestBody DNADataForm dnaData) {
        List<List<String>> dnaList = new ArrayList<>();

        dnaData.getDna().forEach(item -> {

            List<String> adn = new ArrayList<>();

            for(int i = 0; i < item.length(); i++) {
                char chasrs = item.charAt(i);
                adn.add(String.valueOf(chasrs));
            }
            dnaList.add(adn);
        });

        humanService.validateDNA(dnaList);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
