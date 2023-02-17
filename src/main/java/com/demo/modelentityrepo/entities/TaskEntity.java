package com.demo.modelentityrepo.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "task",orphanRemoval = true)
    List<NoteEntity> notes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<NoteEntity> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteEntity> notes) {
        this.notes = notes;
    }
}
