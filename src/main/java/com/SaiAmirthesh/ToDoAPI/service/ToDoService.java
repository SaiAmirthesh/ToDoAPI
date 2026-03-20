package com.SaiAmirthesh.ToDoAPI.service;

import com.SaiAmirthesh.ToDoAPI.models.ToDo;
import com.SaiAmirthesh.ToDoAPI.models.User;
import com.SaiAmirthesh.ToDoAPI.repository.ToDoRepository;
import com.SaiAmirthesh.ToDoAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<ToDo> getAllToDos() {
        User user = getCurrentUser();
        return toDoRepository.findByUser(user);
    }

    public ToDo createToDo(ToDo toDo) {
        User user = getCurrentUser();
        toDo.setUser(user);
        return toDoRepository.save(toDo);
    }

    public ToDo getToDoById(Long id) {
        User user = getCurrentUser();
        return toDoRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("ToDo not found"));
    }

    public ToDo updateToDo(Long id, ToDo updatedToDo) {
        User user = getCurrentUser();

        ToDo existingToDo = toDoRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("ToDo not found"));

        existingToDo.setTitle(updatedToDo.getTitle());
        existingToDo.setDescription(updatedToDo.getDescription());
        existingToDo.setIsCompleted(updatedToDo.getIsCompleted());

        return toDoRepository.save(existingToDo);
    }

    public void deleteToDo(Long id) {
        User user = getCurrentUser();

        ToDo toDo = toDoRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("ToDo not found"));

        toDoRepository.delete(toDo);
    }
}