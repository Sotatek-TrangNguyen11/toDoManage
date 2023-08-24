package me.example.toDoManage.service;

import me.example.toDoManage.model.entity.ToDo;
import me.example.toDoManage.model.entity.ToDoValidator;
import me.example.toDoManage.model.payload.TodoRes;
import me.example.toDoManage.model.payload.UserRes;
import me.example.toDoManage.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ToDoValidator toDoValidator;

    /**
     * Lấy ra danh sách các ToDo
     * @return
     */
    public List<TodoRes> findAll() {
        List<TodoRes> todoResList = new ArrayList<>();
        for (ToDo toDo : todoRepository.findAll()) {
            todoResList.add(
                    new TodoRes(toDo.getId(), toDo.getTitle(), toDo.getDetail(), new UserRes(toDo.getUser().getId(), toDo.getUser().getUsername()))
            );
            System.out.println(todoResList.get(0));
        }
        return todoResList;
    }

    /**
     * Lấy ra một ToDo theo id
     * @param id
     * @return
     */
    public ToDo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    /**
     * Thêm mới một ToDo
     * @param toDo
     * @return
     */
    public ToDo add(ToDo toDo) {
        if (toDoValidator.isValid(toDo)) {
            return todoRepository.save(toDo);
        }
        return null;
    }

    /**
     * Xóa một ToDo
     * @param id
     */
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    /**
     * Cập nhật một ToDo
     * @param toDo
     * @return
     */
    public ToDo update(ToDo toDo) {
        if (toDoValidator.isValid(toDo)) {
            return todoRepository.save(toDo);
        }
        return null;
    }

}
