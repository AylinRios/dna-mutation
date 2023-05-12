package adnmutation.controller;

import adnmutation.dto.StatsDTO;
import adnmutation.service.DnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
