package adnmutation.controller;

import adnmutation.assertions.Assertions;
import adnmutation.dto.SessionInformationDTO;
import adnmutation.dto.Message;
import adnmutation.entity.User;
import adnmutation.form.AuthUserForm;
import adnmutation.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<SessionInformationDTO> login(@Valid @RequestBody AuthUserForm authUser, BindingResult bindingResult){

        if(bindingResult.hasErrors())
           return new ResponseEntity(new Message("Check entered fields"), HttpStatus.BAD_REQUEST);

        if(userService.existsByUserName(authUser.getUsername())) {

            Optional<User> user= userService.getByUserName(authUser.getUsername());

            Assertions.isNull("User", user);

            SessionInformationDTO sessionInformationDTO = new SessionInformationDTO( authUser.getUsername(), user.get().getId());

            return ResponseEntity.ok(sessionInformationDTO);
        }

        return new ResponseEntity(new  Message("User does not exist"), HttpStatus.BAD_REQUEST);
    }

}
