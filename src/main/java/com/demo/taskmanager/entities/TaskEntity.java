package com.demo.taskmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity(name = "tasks")
@Table(indexes = @Index(columnList = "title"))
public class TaskEntity extends BaseEntity{
    @Column(name = "title", nullable = false,length = 150)
    String title;

    @Column(name = "description",nullable = true,length = 500)
    String description;

    @Column(name = "completed",nullable = false,columnDefinition = "boolean default false")
    Boolean completed = false;

    @Column(name = "due_date",nullable = true)
    Date dueDate;

    @OneToMany(mappedBy = "task",orphanRemoval = true)
    List<NoteEntity> notes;

}
