package com.demo.modelentityrepo.repositories;

import com.demo.modelentityrepo.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TasksRepositoryTest {
    @Autowired
    TasksRepository tasksRepository;

    public void CreateTaskEntityTest(){
        TaskEntity task = new TaskEntity();
        task.setTitle("Test Title");
        task.setDescription("Test Description");
        task.setCompleted(false);
        var saveTask = tasksRepository.save(task);
        assertNotNull(saveTask);
    }

}
