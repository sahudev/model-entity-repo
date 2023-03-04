package com.demo.taskmanager.repositories;

import com.demo.taskmanager.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity,Integer> {
    List<TaskEntity> findAllByCompleted(boolean completed);
    TaskEntity findByTitle(String title);
}
