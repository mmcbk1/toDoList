package com.wyrzel.todoscrum.controller;

import com.wyrzel.todoscrum.entity.Task;
import com.wyrzel.todoscrum.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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


    @PutMapping(path= "task/{id}/status")
    public Task putTask(@RequestBody Task task, @PathVariable Long id)
    {
        Optional<Task> taskOptional= taskRepository.findById(id);
        Task updatedTask= taskOptional.get();
        updatedTask.setStatus(task.getStatus());

        return taskRepository.save(updatedTask);
    }
}
