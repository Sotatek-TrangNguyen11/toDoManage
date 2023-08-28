package me.example.toDoManage.model.payload;

public class ObjectRes {

    private StatusRes status;
    private Object data;

    public ObjectRes(StatusRes status, Object data) {
        this.status = status;
        this.data = data;
    }

    public StatusRes getStatus() {
        return status;
    }

    public void setStatus(StatusRes status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
