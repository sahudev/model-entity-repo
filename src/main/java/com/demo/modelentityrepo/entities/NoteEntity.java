package com.demo.modelentityrepo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "Notes")
public class NoteEntity extends BaseEntity{

    @Column(name = "body",nullable = false,length = 500)
    String body;

    @ManyToOne
    TaskEntity task;
}
