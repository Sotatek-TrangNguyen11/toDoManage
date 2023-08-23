package me.example.toDoManage.repository;

import me.example.toDoManage.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Long> {

}
