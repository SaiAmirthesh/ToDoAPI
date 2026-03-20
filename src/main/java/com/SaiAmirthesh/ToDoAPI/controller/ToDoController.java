package com.SaiAmirthesh.ToDoAPI.controller;

import com.SaiAmirthesh.ToDoAPI.models.ToDo;
import com.SaiAmirthesh.ToDoAPI.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping("/create")
    public ResponseEntity<ToDo> createTodo(@Valid @RequestBody ToDo todo) {
        ToDo createdTodo = toDoService.createToDo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllTodos() {
        return ResponseEntity.ok(toDoService.getAllToDos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(toDoService.getToDoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateTodo(@PathVariable Long id, @Valid @RequestBody ToDo todo) {
        ToDo updatedTodo = toDoService.updateToDo(id, todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }
}