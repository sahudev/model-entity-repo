package com.demo.taskmanager.controllers;


import com.demo.taskmanager.dtos.CreateTaskDTO;
import com.demo.taskmanager.dtos.TaskResponseDTO;
import com.demo.taskmanager.dtos.UpdateTaskDTO;
import com.demo.taskmanager.entities.TaskEntity;
import com.demo.taskmanager.errors.ErrorResponse;
import com.demo.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
@Autowired
    TaskService taskService;

    //To create a new task
    @PostMapping("")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody CreateTaskDTO createTaskDTO){
        var savedTask = taskService.createTask(createTaskDTO);
        return ResponseEntity.created(URI.create("/tasks/"+savedTask.getId())).body(savedTask);
    }

    //Get All tasks
    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getAllTask(){
        var taskList = taskService.getAllTasks();
        return ResponseEntity.ok(taskList);
    }

    // Get Task by ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    // Patch or update an existing task
    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTaskById(
            @RequestBody UpdateTaskDTO updateTaskDTO,
            @PathVariable("id") Integer id){
        return ResponseEntity.accepted().body(taskService.updateTaskById(id, updateTaskDTO));
    }

    // Delete a slide
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<TaskEntity>> deleteTask(@PathVariable("id") Integer id){
       var deletedTask = taskService.deleteTask(id);
        return ResponseEntity.accepted().body(deletedTask);
    }

    // Get Task by Title
    @GetMapping("?")
    public ResponseEntity<TaskEntity> getTaskByTitle(@RequestParam String title ){
        return ResponseEntity.ok(taskService.getTaskByTitle(title));
    }

    // Error Handler
    @ExceptionHandler(TaskService.TaskNotFoundException.class)
    ResponseEntity<ErrorResponse> handleErrors(TaskService.TaskNotFoundException e){
        return new ResponseEntity<>(
                new ErrorResponse(e.getMessage()),
                HttpStatus.NOT_FOUND);
    }

}