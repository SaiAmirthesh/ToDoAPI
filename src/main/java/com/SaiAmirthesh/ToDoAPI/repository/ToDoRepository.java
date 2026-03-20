package com.SaiAmirthesh.ToDoAPI.repository;

import com.SaiAmirthesh.ToDoAPI.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository <ToDo,Long> {

}
