package com.fluffy.noteapp.service;

import com.fluffy.noteapp.model.Note;
import com.fluffy.noteapp.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class NotAppServiceTest {
    private NoteAppService service;
    private NoteRepository noteRepo;

    @BeforeEach
    public void setup()
    {
        noteRepo = Mockito.mock(NoteRepository.class);
        service = new NoteAppService(noteRepo);
    }
    @Test
    void getAll(){
        List<Note> mockList = List.of(new Note("Title1"));
        when(noteRepo.findAll()).thenReturn(mockList);
        List<Note> result = service.getAll();

        assertEquals(1, result.size());
        assertEquals("Title1", result.get(0).getTitle());
        verify(noteRepo, times(1)).findAll();
    }
    @Test
    void getById(){
        Note mockNote = Mockito.mock(Note.class);
        mockNote.setId(1L);
        mockNote.setTitle("Title1");
        when(noteRepo.findById(1L)).thenReturn(Optional.of(mockNote));

        Note result = service.findById(1L);
        assertEquals(mockNote.getTitle(), result.getTitle());
        verify(noteRepo, times(1)).findById(1L);

    }
}
