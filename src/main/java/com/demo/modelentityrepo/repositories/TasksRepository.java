package com.demo.modelentityrepo.repositories;

import com.demo.modelentityrepo.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TaskEntity,Integer> {
}
