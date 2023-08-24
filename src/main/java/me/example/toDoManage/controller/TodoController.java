package me.example.toDoManage.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.example.toDoManage.model.entity.ToDo;
import me.example.toDoManage.model.payload.TodoRes;
import me.example.toDoManage.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "TodoController", description = "API for TodoController")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/listTodo")
    public List<TodoRes> listTodo() {
        return todoService.findAll();
    }

    @GetMapping("/getTodo/{id}")
    public ToDo getTodoById(@PathVariable("id") Long id) {
        return todoService.findById(id);
    }

    @PostMapping("/addTodo")
    public ToDo addTodo(@RequestBody ToDo toDo) {
        return todoService.add(toDo);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteById(id);
        return "Xóa thành công Todo vơi Id: " + id;
    }

    @PutMapping("/updateTodo")
    public ToDo editTodo(@RequestBody ToDo toDo) {
        return todoService.update(toDo);
    }

}
