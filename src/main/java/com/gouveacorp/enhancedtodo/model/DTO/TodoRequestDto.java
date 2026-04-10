package com.gouveacorp.enhancedtodo.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequestDto {
    private Long id;

    private String task;

    private Boolean completed;
}
