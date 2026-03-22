package com.gouveacorp.enhancedtodo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    @NonNull
    private String task;

    @NonNull
    private Boolean completed;
}
