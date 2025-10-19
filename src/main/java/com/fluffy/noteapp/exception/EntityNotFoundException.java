package com.fluffy.noteapp.exception;

import org.springframework.data.crossstore.ChangeSetPersister;


public class EntityNotFoundException extends ChangeSetPersister.NotFoundException {
    public EntityNotFoundException(String message) {
        super();
    }
}
