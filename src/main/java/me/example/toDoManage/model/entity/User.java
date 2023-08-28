package me.example.toDoManage.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data // Tự động tạo getter, setter, toString, equals, hashCode
@Entity // Đánh dấu đây là một entity
@AllArgsConstructor // Tự động tạo constructor với toàn bộ tham số
@NoArgsConstructor // Tự động tạo constructor không tham số
@Table(name = "user") // Map với bảng có tên là user
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

