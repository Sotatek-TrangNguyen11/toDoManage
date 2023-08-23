package me.example.toDoManage;

import me.example.toDoManage.repository.TodoRepository;
import me.example.toDoManage.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoManageApplication {


	public static void main(String[] args) {

		SpringApplication.run(ToDoManageApplication.class, args);
	}




}
