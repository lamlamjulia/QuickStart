package com.fluffy.noteapp.service;

import org.springframework.stereotype.Service;
import com.fluffy.noteapp.model.Note;
import com.fluffy.noteapp.repository.NoteRepository;
import java.util.List;


@Service
public class NoteAppService {
    private NoteRepository repo;

    public NoteAppService(NoteRepository repo) {
        this.repo = repo;
    }
    public Note createNote(Note note)
    {
        if(note.getTitle() == null || note.getTitle().isBlank())
        {
            throw new IllegalArgumentException("Title is required");
        }
        return repo.save(note);
    }
    public Note findById(Long id)
    {
        return repo.findById(id).orElse(null);
    }
    public List<Note> getAll()
    {
        return repo.findAll();
    }
    public void updateNote(Long id, Note updatedNote)
    {
        Note currentNote = findById(id);
        currentNote.setTitle(updatedNote.getTitle());
        currentNote.setContent(updatedNote.getContent());
        currentNote.setCreateAt(updatedNote.getCreateAt());
        repo.save(currentNote);
    }
    public void deleteNote(Long id)
    {
        repo.deleteById(id);
    }
}
