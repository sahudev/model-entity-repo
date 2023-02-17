package com.demo.modelentityrepo.repositories;

import com.demo.modelentityrepo.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NoteEntity,Integer> {
}
