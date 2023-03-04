package com.demo.taskmanager.services;

import com.demo.taskmanager.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteService {

    @Autowired
    NotesRepository notesRepository;

}
