package com.wyrzel.todoscrum.repository;

import com.wyrzel.todoscrum.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
