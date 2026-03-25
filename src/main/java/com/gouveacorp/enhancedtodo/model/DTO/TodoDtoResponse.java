package com.gouveacorp.enhancedtodo.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoDtoResponse {

    private Long id;

    private String task;

    private Boolean completed;
}
