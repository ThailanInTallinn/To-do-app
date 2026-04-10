package com.gouveacorp.enhancedtodo.service;

import com.gouveacorp.enhancedtodo.customExceptions.TodoNotExistByIdException;
import com.gouveacorp.enhancedtodo.model.DTO.TodoRequestDto;
import com.gouveacorp.enhancedtodo.model.DTO.TodoResponseDto;
import com.gouveacorp.enhancedtodo.model.Todo;
import com.gouveacorp.enhancedtodo.model.DTO.TodoDto;
import com.gouveacorp.enhancedtodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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

    public List<TodoResponseDto> getTodos() {

        return todoRepository.findAll()
                .stream()
                .map(td -> td.entityToResponseDto(td))
                .toList();
    }

    @SneakyThrows
    public TodoResponseDto editTodo(Long id, TodoRequestDto dto) {
        try{
            Todo oldTodo = todoRepository.findById(id)
                    .orElseThrow(() -> new TodoNotExistByIdException("Todo with id " + id + " does not exist."));
            oldTodo.setTask(dto.getTask());
            oldTodo.setCompleted(dto.getCompleted());
            todoRepository.save(oldTodo);
            return new TodoResponseDto(id, dto.getTask(), dto.getCompleted());
        } catch(TodoNotExistByIdException e){
            throw new RuntimeException("Failed to update todo with id " + id, e);
        }

    }
}
