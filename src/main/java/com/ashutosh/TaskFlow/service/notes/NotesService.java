package com.ashutosh.TaskFlow.service.notes;



import com.ashutosh.TaskFlow.model.Note;

import java.util.List;


public interface NotesService {
//    Task findTaskById(int taskId);

    List<Note> getNotesByTaskId(int taskId);

    Note getNoteByIdAndTaskId(int id, int taskId);

    void createNoteForTaskId(int taskId, Note note);

    void deleteNote(int id, int taskId);

    void deleteNotes(int taskId);

    void updateNote(int id, int taskId, Note note);

    class NoteNotFoundException extends IllegalArgumentException {
        public NoteNotFoundException(int id){
            super("Could not find note with id: " + id);
        }
    }
}
