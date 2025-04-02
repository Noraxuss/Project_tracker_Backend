package project_tracker_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project_tracker_backend.dto.incoming.UserCreationDto;
import project_tracker_backend.service.UserService;

@RestController
@RequestMapping("/api/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody UserCreationDto userCreationDto) {
        //TODO logging
        System.out.println("Registering user: " + userCreationDto);
        userService.registerUser(userCreationDto);
    }
}
