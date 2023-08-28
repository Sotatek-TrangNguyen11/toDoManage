package me.example.toDoManage.model.payload;

import me.example.toDoManage.model.entity.User;

public class UserRes {
    private Long id;
    private String username;

    public UserRes(Long id, String username) {
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
}
