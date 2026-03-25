package com.gouveacorp.enhancedtodo.service;

import com.gouveacorp.enhancedtodo.model.DTO.TodoDtoResponse;
import com.gouveacorp.enhancedtodo.model.Todo;
import com.gouveacorp.enhancedtodo.model.DTO.TodoDto;
import com.gouveacorp.enhancedtodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public Todo createTodo(TodoDto todoDto){
        if(todoDto != null){
            LocalDateTime now = LocalDateTime.now();
            Todo todoObj = new Todo();
            todoObj.dtoToEntity(todoDto);
            todoObj.setCreatedAt(now);
            todoObj.setUpdatedAt(now);
            return todoRepository.save(todoObj);
        } else {
            throw new IllegalArgumentException("To-do cannot be null.");
        }

    }

    public List<TodoDtoResponse> getTodos(){
        
        return todoRepository.findAll()
                .stream()
                .map(td -> td.entityToResponseDto(td))
                .toList();
    }
}
