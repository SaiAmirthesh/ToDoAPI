package com.SaiAmirthesh.ToDoAPI.repository;

import com.SaiAmirthesh.ToDoAPI.models.ToDo;
import com.SaiAmirthesh.ToDoAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository <ToDo,Long> {
    List<ToDo> findByUser(User user);
    Optional<ToDo> findByIdAndUser(Long id, User user);
}
