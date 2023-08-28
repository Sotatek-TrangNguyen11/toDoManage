package me.example.toDoManage.model.payload;

public class TodoRes {
    private Long id;
    private String title;
    private String detail;
    private String userName;

    public TodoRes(Long id, String title, String detail, String userName) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
