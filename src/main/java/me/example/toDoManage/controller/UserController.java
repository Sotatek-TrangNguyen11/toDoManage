package me.example.toDoManage.controller;

import lombok.AllArgsConstructor;
import me.example.toDoManage.model.entity.User;
import me.example.toDoManage.model.payload.UserRes;
import me.example.toDoManage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRes> register(@RequestBody User user) {
        String result = userService.addUser(user);
//        if (result == "")
        return null;
    }

}
