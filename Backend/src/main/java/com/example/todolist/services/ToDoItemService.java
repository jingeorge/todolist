package com.example.todolist.services;

import com.example.todolist.entities.ToDoItem;
import com.example.todolist.repositories.ToDoItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    public List<ToDoItem> findAll() {
        return toDoItemRepository.findAll();
    }

    public ToDoItem findById(int id) {
        return toDoItemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item does not exist"));
    }

    public ToDoItem save(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    public void deleteById(int id) {
        toDoItemRepository.deleteById(id);
    }
}
