package com.wyrzel.todoscrum.controller;

import com.wyrzel.todoscrum.entity.Task;
import com.wyrzel.todoscrum.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/tasks")
    public Iterable<Task> GetTast()
    {
        return taskRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "task/create")
    public Task postTask(@RequestBody Task task)
    {
        return taskRepository.save(task);
    }
}
