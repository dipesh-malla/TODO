package com.dipesh.todolist.repository;

import com.dipesh.todolist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Long> {
}
