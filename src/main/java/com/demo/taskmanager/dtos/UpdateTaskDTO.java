package com.demo.taskmanager.dtos;

import com.demo.taskmanager.entities.NoteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTaskDTO {
    Integer id;
    String title;
    String description;
    Date dueDate;
    Boolean completed;
    List<NoteEntity> notes;
}
