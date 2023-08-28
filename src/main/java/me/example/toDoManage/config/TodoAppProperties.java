package me.example.toDoManage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
public class TodoAppProperties {
    public static String validateRegisterUserName = "Tên đăng nhập đã tồn tại";
    public static String validateRegisterUserId = "Người dùng đã tồn tại";
    public static String successAddUser = "Thêm người dùng thành công";

    public static String failLogin = "Chưa có người dùng này";
    public static String failPass = "Sai mật khẩu";
    public static String successLogin = "Đăng nhập thành công";

    public static String successGetAllUser = "Lấy danh sách người dùng thành công";
    public static String failGetAllUer = "Lấy danh sách người dùng thất bại";
    public static String successGetUser = "Lấy thông tin người dùng thành công";
    public static String failGetUer = "Lấy thông tin người dùng thất bại";


    public static String successAddTodo = "Thêm công việc thành công";
    public static String failAddTodo = "Thêm công việc thất bại";
    public static String successDeleteTodo = "Xóa công việc thành công";
    public static String failDeleteTodo = "Xóa công việc thất bại";
    public static String successUpdateTodo = "Cập nhật công việc thành công";
    public static String failUpdateTodo = "Cập nhật công việc thất bại";
    public static String successGetAllTodo = "Lấy danh sách công việc thành công";
    public static String failGetAllTodo = "Lấy danh sách công việc thất bại";
    public static String successGetTodoById = "Lấy công việc thành công";
    public static String failGetTodoById = "Lấy công việc thất bại";


}
