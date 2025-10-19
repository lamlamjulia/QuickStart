package com.fluffy.noteapp.controller;

import com.fluffy.noteapp.service.NoteAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.fluffy.noteapp.model.Note;

@RestController
public class NoteAppController {
    private NoteAppService service;

    public NoteAppController(NoteAppService service) {
        this.service = service;
    }

    @GetMapping("/homepage")
    public List<Note> homePage() {
        return service.getAll();
    }

    @GetMapping("/homepage/{id}")
    public Note getById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @PostMapping("/homepage")
    public ResponseEntity<Note> createNote(@RequestBody Note note)
    {
         note.setId(null);
         Note saved = service.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/homepage/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody Note update)
    {
        service.updateNote(id, update);
    }

    @DeleteMapping("/homepage/{id}")
    public void deleteNote(@PathVariable Long id)
    {
        service.deleteNote(id);
    }
}
