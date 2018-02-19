package com.mk.recipeproject.api.mapper;

import com.mk.recipeproject.api.model.NotesDTO;
import com.mk.recipeproject.model.Notes;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class NotesMapperTest {

    private NotesMapper notesMapper = NotesMapper.INSTANCE;

    @Test
    public void notesToNotesDTO() {
        Notes notes = new Notes();
        notes.setId(1L);
        notes.setRecipeNotes("recipe notes");

        NotesDTO notesDTO = notesMapper.notesToNotesDTO(notes);
        assertEquals(notes.getId(), notesDTO.getId());
        assertEquals(notes.getRecipeNotes(), notesDTO.getRecipeNotes());
    }

    @Test
    public void notesDTOToNotes() {
        NotesDTO notesDTO = new NotesDTO();
        notesDTO.setId(2L);
        notesDTO.setRecipeNotes("notes");

        Notes notes = notesMapper.notesDTOToNotes(notesDTO);
        assertEquals(notesDTO.getId(), notes.getId());
        assertEquals(notesDTO.getRecipeNotes(), notes.getRecipeNotes());
    }
}