package com.gouveacorp.enhancedtodo.model;

import com.gouveacorp.enhancedtodo.model.DTO.TodoDto;
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

    private String createdBy;

    public Todo dtoToEntity(TodoDto dto){
        this.task = dto.getTask();
        this.completed = dto.getCompleted();
        return this;
    }

}
