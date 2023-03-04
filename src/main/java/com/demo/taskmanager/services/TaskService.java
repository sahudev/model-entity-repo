package com.demo.taskmanager.services;

import com.demo.taskmanager.dtos.CreateTaskDTO;
import com.demo.taskmanager.dtos.TaskResponseDTO;
import com.demo.taskmanager.dtos.UpdateTaskDTO;
import com.demo.taskmanager.entities.TaskEntity;
import com.demo.taskmanager.repositories.NotesRepository;
import com.demo.taskmanager.repositories.TasksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TasksRepository tasksRepository;
    @Autowired
    NotesRepository notesRepository;
    @Autowired
    ModelMapper modelMapper;

    public TaskResponseDTO createTask(CreateTaskDTO createTaskDTO){
        var savedTask = modelMapper.map(createTaskDTO,TaskEntity.class);
        // TODO: Check due date is greater than current date
        return modelMapper.map(tasksRepository.save(savedTask),TaskResponseDTO.class);
    }

    public List<TaskEntity> getAllTasks(){
        return tasksRepository.findAll();
    }

    public TaskEntity getTaskById(Integer id){
        return tasksRepository.findAll().stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(()-> new TaskNotFoundException(id));
    }

    public TaskEntity updateTaskById(Integer id, UpdateTaskDTO updateTaskDTO) {
        var updateTask = modelMapper.map(updateTaskDTO,TaskEntity.class);
        return tasksRepository.save(updateTask);
    }

    public Optional<TaskEntity> deleteTask(Integer id) {
        var deleteTask = tasksRepository.findById(id);
        if(deleteTask !=null) {
            tasksRepository.deleteById(id);
            return deleteTask;
        } else{
            throw new TaskNotFoundException(id);
        }
    }

    public TaskEntity getTaskByTitle(String title){
        return tasksRepository.findByTitle(title);

       /* return tasksRepository.findAll().stream()
                .filter(task -> task.getTitle().equals(title))
                .findFirst()
                .orElseThrow(()-> new TaskNotFoundException(title));

        */
    }

    public static class TaskNotFoundException extends IllegalStateException{
        public TaskNotFoundException(Integer id){
            super("Task Id " + id + " not found");
        }

        public TaskNotFoundException(String title){
            super("Task with title " + title + " not found");
        }
    }


    // TODO Error Handling
}