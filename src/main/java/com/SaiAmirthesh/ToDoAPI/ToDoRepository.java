package com.SaiAmirthesh.ToDoAPI;

import com.SaiAmirthesh.ToDoAPI.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface ToDoRepository extends JpaRepository <ToDo,Long> {

}
