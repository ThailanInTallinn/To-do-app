package com.gouveacorp.enhancedtodo.model;

import com.gouveacorp.enhancedtodo.model.DTO.TodoDto;
import com.gouveacorp.enhancedtodo.model.DTO.TodoRequestDto;
import com.gouveacorp.enhancedtodo.model.DTO.TodoResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Data
@Table(name = "Todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;

    private Boolean completed;

    @Column(name="createdat")
    private LocalDateTime createdAt;

    @Column(name="updatedat")
    private LocalDateTime updatedAt;

    public Todo dtoToEntity(TodoDto dto){
        this.task = dto.getTask();
        this.completed = dto.getCompleted();
        return this;
    }

    public TodoResponseDto entityToResponseDto(Todo todo){
        return new TodoResponseDto(todo.getId(), todo.getTask(), todo.getCompleted());

    }

}
