package me.example.toDoManage.model.payload;

public class TodoRes {
    private Long id;
    private String title;
    private String detail;
    private UserRes user;

    public TodoRes(Long id, String title, String detail, UserRes user) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public UserRes getUser() {
        return user;
    }

    public void setUser(UserRes user) {
        this.user = user;
    }
}
