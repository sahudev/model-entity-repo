package com.demo.taskmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Notes")
public class NoteEntity extends BaseEntity{

    @Column(name = "body",nullable = false,length = 500)
    String body;

    @ManyToOne
    TaskEntity task;
}
