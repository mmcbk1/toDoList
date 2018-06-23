package com.wyrzel.todoscrum.controller;

import com.wyrzel.todoscrum.entity.Task;
import com.wyrzel.todoscrum.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping(path = "/tasks")
    public Iterable<Task> GetTast()
    {
        return taskRepository.findAll();
    }


    @PostMapping(path = "task/create")
    public Task postTask(@RequestBody Task task)
    {
        return taskRepository.save(task);
    }
}
