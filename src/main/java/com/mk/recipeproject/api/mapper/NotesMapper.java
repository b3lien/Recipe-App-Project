package com.mk.recipeproject.api.mapper;

import com.mk.recipeproject.api.model.NotesDTO;
import com.mk.recipeproject.model.Notes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotesMapper {

    NotesMapper INSTANCE = Mappers.getMapper(NotesMapper.class);

    NotesDTO notesToNotesDTO(Notes notes);

    Notes notesDTOToNotes(NotesDTO notesDTO);
}
