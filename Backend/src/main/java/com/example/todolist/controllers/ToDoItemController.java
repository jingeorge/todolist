package com.example.todolist.controllers;

import com.example.todolist.entities.ToDoItem;
import com.example.todolist.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoItemController {

    @Autowired
    private ToDoItemService toDoItemService;

    @GetMapping
    public List<ToDoItem> getAllToDoItems() {
        return toDoItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getToDoItemById(@PathVariable int id) {
        return new ResponseEntity<ToDoItem>(toDoItemService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createToDoItem(@RequestBody ToDoItem toDoItem) {
        return new ResponseEntity<ToDoItem>(toDoItemService.save(toDoItem), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateToDoItem(@PathVariable int id, @RequestBody ToDoItem newToDoItem) {
        newToDoItem.setId(id);
        toDoItemService.save(newToDoItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToDoItem(@PathVariable int id) {
        toDoItemService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
