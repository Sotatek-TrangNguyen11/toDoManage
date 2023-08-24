package me.example.toDoManage.model.entity;

/*
Đối tượng này dùng để kiểm tra xem một Object Todo có hợp lệ không
 */

public class ToDoValidator {

    /**
     * Kiểm tra xem một Object Todo có hợp lệ không
     * @param toDo
     * @return
     */
    public static boolean isValid(ToDo toDo) {
        if (toDo.getTitle() == null || toDo.getTitle().trim().isEmpty()) {
            return false;
        }
        if (toDo.getDetail() == null || toDo.getDetail().trim().isEmpty()) {
            return false;
        }
        return true;

    }
}
