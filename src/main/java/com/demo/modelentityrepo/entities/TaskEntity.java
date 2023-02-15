package com.demo.modelentityrepo.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "tasks")
@Table(indexes = @Index(columnList = "title"))
public class TaskEntity extends BaseEntity{
    @Column(name = "title", nullable = false,length = 150)
    String title;

    @Column(name = "description",nullable = true,length = 500)
    String description;

    @Column(name = "completed",nullable = false,columnDefinition = "boolean default false")
    Boolean completed;

    @Column(name = "due_date",nullable = true)
    Date dueDate;
}
