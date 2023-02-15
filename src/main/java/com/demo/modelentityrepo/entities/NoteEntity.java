package com.demo.modelentityrepo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "Notes")
public class NoteEntity extends BaseEntity{

    @Column(name = "body",nullable = false,length = 500)
    String body;
}
