package com.SaiAmirthesh.ToDoAPI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
@Entity
@Data

public class ToDo {
    @Id
    @GeneratedValue
    Long id;

    @NotBlank
    @Column(nullable = false)
    String title;

    String description;

    @NotNull
    @Column(nullable = false)
    Boolean isCompleted;
}
