package com.SaiAmirthesh.ToDoAPI.controller;

import com.SaiAmirthesh.ToDoAPI.service.ToDoService;
import com.SaiAmirthesh.ToDoAPI.models.ToDo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1/todo")
@Slf4j
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    //creating todos
    @PostMapping("/create")
    ResponseEntity<ToDo> createTodo(@Valid @RequestBody ToDo todo) {
        log.info("Task created with id: " + id);
        return new ResponseEntity<>(toDoService.createTodo(todo), HttpStatus.CREATED);
    }

    //viewing each todo
    @GetMapping("/{id}")
    ResponseEntity<ToDo> getToDoById(@PathVariable Long id){
        try {
            ToDo fetchedtodo = toDoService.getToDoById(id);
            return new ResponseEntity<>(fetchedtodo,HttpStatus.OK);
        }
        catch (RuntimeException exception) {
            log.error("Not found",exception);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    ResponseEntity<List<ToDo>> getToDos(){
        return new ResponseEntity<List<ToDo>>(toDoService.getToDos(),HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<ToDo>> getAllToDoPages(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<Page<ToDo>>(toDoService.getAllToDoPages(page,size),HttpStatus.OK);
    }


    @PutMapping("/update")
    ResponseEntity<ToDo> updateToDo(@RequestBody ToDo todo){
        log.info("updated a todo");
        return new ResponseEntity<>(toDoService.updateToDo(todo),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteToDoById(@PathVariable Long id){
        toDoService.deleteToDoById(id);
    }

}
