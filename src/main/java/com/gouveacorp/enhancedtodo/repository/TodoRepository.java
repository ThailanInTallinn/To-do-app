package com.gouveacorp.enhancedtodo.repository;

import com.gouveacorp.enhancedtodo.model.Todo;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
