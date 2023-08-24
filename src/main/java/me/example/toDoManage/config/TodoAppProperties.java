package me.example.toDoManage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "todoapp")
public class TodoAppProperties {
    public String name;
}
