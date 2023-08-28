package me.example.toDoManage.model.payload;

public class StatusRes {
    public static final String STATUS_200 = "200 - OK";
    public static final String STATUS_400 = "400 - Bad Request";
    public static final String STATUS_401 = "401 - Unauthorized";
    public static final String STATUS_403 = "403 - Forbidden";
    public static final String STATUS_404 = "404 - Not Found";
    public static final String STATUS_500 = "500 - Internal Server Error";

    private String code;
    private String message;

    public StatusRes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
