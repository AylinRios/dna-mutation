package adnmutation.controller;

import adnmutation.dto.MutationDTO;
import adnmutation.dto.StatsDTO;
import adnmutation.service.DnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dna")
public class DnaController {

    private final DnaService dnaService;

    @GetMapping("/stats")
    public ResponseEntity<StatsDTO> getDnaStats(){
        return ResponseEntity.ok(dnaService.getDnaStats());
    }

    @GetMapping("/records-mutated-onmutated/{hasMutation}")
    public ResponseEntity<List<MutationDTO>> mutationAccounting(@PathVariable boolean hasMutation){
        return ResponseEntity.ok(dnaService.mutationAccounting(hasMutation));
    }

    @GetMapping("/records")
    public  ResponseEntity<List<MutationDTO>> records(){
        return ResponseEntity.ok(dnaService.records());
    }


}
