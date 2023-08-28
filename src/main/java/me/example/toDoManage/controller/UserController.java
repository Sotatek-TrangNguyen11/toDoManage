package me.example.toDoManage.controller;

import lombok.AllArgsConstructor;
import me.example.toDoManage.config.TodoAppProperties;
import me.example.toDoManage.model.entity.User;
import me.example.toDoManage.model.payload.LoginReq;
import me.example.toDoManage.model.payload.ObjectRes;
import me.example.toDoManage.model.payload.StatusRes;
import me.example.toDoManage.model.payload.UserRes;
import me.example.toDoManage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ObjectRes> register(@RequestBody User user) {
        ObjectRes objectRes = userService.addUser(user);
        if (objectRes.getStatus().getCode() == StatusRes.STATUS_200) {
            return ResponseEntity.ok(objectRes);
        } else {
            return ResponseEntity.badRequest().body(objectRes);
        }
    }

    @GetMapping()
    public ResponseEntity<ObjectRes> listUser() {
        ObjectRes objectRes = userService.getAllUser();
        if (objectRes.getStatus().getCode() == StatusRes.STATUS_200)
            return ResponseEntity.ok(objectRes);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ObjectRes> login(@RequestBody LoginReq loginReq) {
        User user = new User(loginReq.getUsername(), loginReq.getPassword());
        ObjectRes objectRes = userService.login(user);
        if (objectRes.getStatus().getCode() == StatusRes.STATUS_200) {
            return ResponseEntity.ok(objectRes);
        } else {
            return ResponseEntity.badRequest().body(objectRes);
        }
    }

}
