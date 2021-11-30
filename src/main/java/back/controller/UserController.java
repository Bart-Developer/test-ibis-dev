package back.controller;

import back.dto.UserDTO;
import back.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create_user")
    private ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        return this.userService.CreateUser(userDTO);
    }

}
