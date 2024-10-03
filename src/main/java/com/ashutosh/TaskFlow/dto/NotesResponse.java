package com.ashutosh.TaskFlow.dto;


import com.ashutosh.TaskFlow.model.Note;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class NotesResponse {
    private int notesCount;
    private List<Note> notes;
}
