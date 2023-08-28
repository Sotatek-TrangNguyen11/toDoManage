package me.example.toDoManage.service;

import me.example.toDoManage.config.TodoAppProperties;
import me.example.toDoManage.model.entity.ToDo;
import me.example.toDoManage.model.entity.ToDoValidator;
import me.example.toDoManage.model.payload.ObjectRes;
import me.example.toDoManage.model.payload.StatusRes;
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
    public ObjectRes findAll() {
        List<TodoRes> todoResList = new ArrayList<>();
        if (todoRepository.findAll() == null) {
            ObjectRes objectRes = new ObjectRes(new StatusRes(StatusRes.STATUS_404, TodoAppProperties.failGetAllTodo), null);
            return objectRes;
        }
        for (ToDo toDo : todoRepository.findAll()) {
            TodoRes todoRes = new TodoRes(toDo.getId(), toDo.getTitle(), toDo.getDetail(), toDo.getUser().getUsername());
            todoResList.add(todoRes);
        }
        return new ObjectRes(new StatusRes(StatusRes.STATUS_200, TodoAppProperties.successGetAllTodo), todoResList);
    }

    /**
     * Lấy ra một ToDo theo id
     * @param id
     * @return
     */
    public ObjectRes findById(Long id) {
        if (todoRepository.findById(id) == null)
            return new ObjectRes(new StatusRes(StatusRes.STATUS_404, TodoAppProperties.failGetTodoById), null);
        else {
            ToDo toDo = todoRepository.findById(id).get();
            TodoRes todoRes = new TodoRes(toDo.getId(), toDo.getTitle(), toDo.getDetail(), toDo.getUser().getUsername());
            return new ObjectRes(new StatusRes(StatusRes.STATUS_200, TodoAppProperties.successGetTodoById), todoRes);
        }
    }

    /**
     * Thêm mới một ToDo
     * @param toDo
     * @return
     */
    public ObjectRes add(ToDo toDo) {
        if (toDoValidator.isValid(toDo)) {
            todoRepository.save(toDo);
            TodoRes todoRes = new TodoRes(toDo.getId(), toDo.getTitle(), toDo.getDetail(), toDo.getUser().getUsername());
            return new ObjectRes(new StatusRes(StatusRes.STATUS_200, TodoAppProperties.successAddTodo), todoRes);
        }
        return new ObjectRes(new StatusRes(StatusRes.STATUS_400, TodoAppProperties.failAddTodo), null);
    }

    /**
     * Xóa một ToDo
     * @param id
     */
    public ObjectRes deleteById(Long id) {
        todoRepository.deleteById(id);
        if (todoRepository.findById(id).get() == null) {
            return new ObjectRes(new StatusRes(StatusRes.STATUS_200, TodoAppProperties.successDeleteTodo), null);
        } else {
            return new ObjectRes(new StatusRes(StatusRes.STATUS_400, TodoAppProperties.failDeleteTodo), null);
        }
    }

    /**
     * Cập nhật một ToDo
     * @param toDo
     * @return
     */
    public ObjectRes update(ToDo toDo) {
        if (toDoValidator.isValid(toDo)) {
            todoRepository.save(toDo);
            TodoRes todoRes = new TodoRes(toDo.getId(), toDo.getTitle(), toDo.getDetail(), toDo.getUser().getUsername());
            return new ObjectRes(new StatusRes(StatusRes.STATUS_200, TodoAppProperties.successUpdateTodo), todoRes);
        }
        return new ObjectRes(new StatusRes(StatusRes.STATUS_400, TodoAppProperties.failUpdateTodo), null);
    }

}
