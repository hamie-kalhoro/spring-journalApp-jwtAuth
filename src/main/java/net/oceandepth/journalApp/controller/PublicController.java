package net.oceandepth.journalApp.controller;

import lombok.extern.slf4j.Slf4j;
import net.oceandepth.journalApp.entity.User;
import net.oceandepth.journalApp.service.UserDetailsServiceImp;
import net.oceandepth.journalApp.service.UserService;
import net.oceandepth.journalApp.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/public")
public class PublicController {

    UserService userService;
    AuthenticationManager authenticationManager;
    UserDetailsServiceImp userDetailsService;
    JwtUtil jwtUtil;

    @Autowired
    public PublicController( UserService userService,
                             AuthenticationManager authenticationManager,
                             UserDetailsServiceImp userDetailsService,
                             JwtUtil jwtUtil ) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("check")
    public String check() {
        return "ok!";
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signup(@RequestBody User userEntry) {
        try {
            userService.saveNewUser(userEntry);
            return new ResponseEntity<>(userEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/log-in")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUserName(), user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Occurred error while generating Authentication-Token", e);
            return new ResponseEntity<>("Incorrect username or password ", HttpStatus.BAD_REQUEST);
        }
    }
}
