package me.example.toDoManage.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.example.toDoManage.model.ToDo;
import me.example.toDoManage.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "TodoController", description = "API for TodoController")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/listTodo")
    public List<ToDo> listTodo() {
        return todoService.findAll();
    }

    @PostMapping("/addTodo")
    public ToDo addTodo(@RequestBody ToDo toDo) {
        return todoService.add(toDo);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public String deleteTodoPost(@PathVariable("id") Long id) {
        todoService.deleteById(id);
        return "Xóa thành công Todo vơi Id: " + id;
    }

    @PutMapping("/updateTodo")
    public ToDo editTodoPost(@RequestBody ToDo toDo) {
        return todoService.update(toDo);
    }

}
