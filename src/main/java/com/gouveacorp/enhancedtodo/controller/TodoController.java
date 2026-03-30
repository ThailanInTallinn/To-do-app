package com.gouveacorp.enhancedtodo.controller;


import com.gouveacorp.enhancedtodo.model.DTO.TodoDtoRequestResponse;
import com.gouveacorp.enhancedtodo.model.Todo;
import com.gouveacorp.enhancedtodo.model.DTO.TodoDto;
import com.gouveacorp.enhancedtodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public Todo createTodo(@RequestBody TodoDto todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping
    public List<TodoDtoRequestResponse> getAllTodos(){
        return todoService.getTodos();
    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable Long id, @RequestBody TodoDtoRequestResponse dto) {
        todoService.editTodo(id, dto);
    }
}
