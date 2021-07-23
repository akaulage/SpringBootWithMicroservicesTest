package com.akaulage.userservice.controller;
import com.akaulage.userservice.CommonDTO.ResponseTemplate;
import com.akaulage.userservice.entity.User;
import com.akaulage.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        log.info("Inside saveUser method of UserService");
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("userId") Long userId)
    {
        log.info("Inside getUserWithDepartment method of UserService");
        return userService.getUserWithDepartment(userId);
    }
}
