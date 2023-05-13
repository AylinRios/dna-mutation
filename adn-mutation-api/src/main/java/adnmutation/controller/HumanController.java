package adnmutation.controller;

import adnmutation.service.HumanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/human")
public class HumanController {

    private final HumanService humanService;
    @PostMapping("/{name}")
    public ResponseEntity<Void> create(@PathVariable String name){

        humanService.create(name);

        return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).build();
    }

    @PostMapping("/mutation")
    public String hasMutation(){


        return "";
    }

}
