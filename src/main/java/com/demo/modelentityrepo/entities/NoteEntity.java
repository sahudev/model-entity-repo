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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }
}
