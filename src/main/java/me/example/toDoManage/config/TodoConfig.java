package me.example.toDoManage.config;

import me.example.toDoManage.model.ToDoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {

    /**
     * Tạo bean TodoValidator
     * @return
     */
    @Bean
    public ToDoValidator toDoValidator() {
        return new ToDoValidator();
    }
}
