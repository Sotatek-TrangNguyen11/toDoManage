package me.example.toDoManage;

import lombok.RequiredArgsConstructor;
import me.example.toDoManage.config.TodoAppProperties;
import me.example.toDoManage.repository.TodoRepository;
import me.example.toDoManage.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoManageApplication implements CommandLineRunner{


	public static void main(String[] args) {

		SpringApplication.run(ToDoManageApplication.class, args);
	}

	@Autowired
	private TodoAppProperties todoAppProperties;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
		System.out.println(todoAppProperties.name);
	}
}
