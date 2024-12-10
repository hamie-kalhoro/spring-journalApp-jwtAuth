package net.oceandepth.journalApp.controller;

import net.oceandepth.journalApp.entity.User;
import net.oceandepth.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    UserService userService;
    @Autowired
    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("check")
    public String check() {
        return "ok!";
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createEntry(@RequestBody User userEntry) {
        try {
            userService.saveNewUser(userEntry);
            return new ResponseEntity<>(userEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
