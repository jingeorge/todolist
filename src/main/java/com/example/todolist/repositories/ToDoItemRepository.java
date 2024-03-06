package com.example.todolist.repositories;

import com.example.todolist.entities.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Integer> {

}
