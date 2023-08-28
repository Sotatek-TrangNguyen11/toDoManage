package me.example.toDoManage.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.example.toDoManage.model.entity.ToDo;
import me.example.toDoManage.model.payload.ObjectRes;
import me.example.toDoManage.model.payload.StatusRes;
import me.example.toDoManage.model.payload.TodoRes;
import me.example.toDoManage.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "TodoController", description = "API for TodoController")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/listTodo")
    public ResponseEntity<ObjectRes> listTodo() {
        ObjectRes objectRes = todoService.findAll();
        if (objectRes.getStatus().getCode() == StatusRes.STATUS_200)
            return ResponseEntity.ok(objectRes);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/getTodo/{id}")
    public ResponseEntity<ObjectRes> getTodoById(@PathVariable("id") Long id) {
        ObjectRes objectRes = todoService.findById(id);
        if (objectRes.getStatus().getCode() == StatusRes.STATUS_200)
            return ResponseEntity.ok(objectRes);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/addTodo")
    public ResponseEntity<ObjectRes> addTodo(@RequestBody ToDo toDo) {
        ObjectRes objectRes = todoService.add(toDo);
        if (objectRes.getStatus().getCode() == StatusRes.STATUS_200)
            return ResponseEntity.ok(objectRes);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/deleteTodo/{id}")
    public ResponseEntity<ObjectRes> deleteTodo(@PathVariable("id") Long id) {
        ObjectRes objectRes = todoService.deleteById(id);
        if (objectRes.getStatus().getCode() == StatusRes.STATUS_200)
            return ResponseEntity.ok(objectRes);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateTodo")
    public ResponseEntity<ObjectRes> editTodo(@RequestBody ToDo toDo) {
        ObjectRes objectRes = todoService.update(toDo);
        if (objectRes.getStatus().getCode() == StatusRes.STATUS_200)
            return ResponseEntity.ok(objectRes);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
