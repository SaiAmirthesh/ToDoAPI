package com.SaiAmirthesh.ToDoAPI;

import com.SaiAmirthesh.ToDoAPI.models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository todorepository ;

    public ToDo createTodo(ToDo todo) {
        return todorepository.save(todo);
    }

    public ToDo getToDoById(Long id){
        return todorepository.findById(id).orElseThrow(()->new RuntimeException("ToDo not found"));
    }

    public Page<ToDo> getAllToDoPages(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return todorepository.findAll(pageable);
    }

    public List<ToDo> getToDos(){
        return todorepository.findAll();
    }

    public ToDo updateToDo(ToDo todo){
        return todorepository.save(todo);
    }

    public void deleteToDoById(Long id){
        todorepository.delete(getToDoById(id));
    }
}
