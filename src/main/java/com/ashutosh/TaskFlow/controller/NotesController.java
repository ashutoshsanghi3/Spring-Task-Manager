package com.ashutosh.TaskFlow.controller;


import com.ashutosh.TaskFlow.dto.ErrorResponse;
import com.ashutosh.TaskFlow.dto.NotesResponse;
import com.ashutosh.TaskFlow.dto.SuccessResponse;
import com.ashutosh.TaskFlow.model.Note;
import com.ashutosh.TaskFlow.service.notes.NotesService;
import com.ashutosh.TaskFlow.service.tasks.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks/{taskId}/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;

    @GetMapping("")
    public ResponseEntity<NotesResponse> getAllNotesByTaskId(@PathVariable int taskId) {
        List<Note> notes = notesService.getNotesByTaskId(taskId);
        return ResponseEntity.ok(new NotesResponse(notes.size(), notes));
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getNoteByIdForTaskId(@PathVariable int taskId, @PathVariable int noteId) {
        Note note = notesService.getNoteByIdAndTaskId(noteId, taskId);
        return ResponseEntity.ok(note);
    }
    @PostMapping("")
    public ResponseEntity<SuccessResponse> createNoteForTaskId(@PathVariable int taskId, @RequestBody Note note) {
        notesService.createNoteForTaskId(taskId, note);
        return new ResponseEntity<>(new SuccessResponse("Note created successfully"),HttpStatus.CREATED);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<SuccessResponse> deleteNote(@PathVariable int taskId, @PathVariable int noteId) {
        notesService.deleteNote(noteId, taskId);
        return ResponseEntity.accepted().body(new SuccessResponse("Note with id: "+ noteId + " deleted successfully"));
    }
    @PatchMapping("/{noteId}")
    public ResponseEntity<SuccessResponse> updateNote(@PathVariable int noteId,@PathVariable int taskId,@RequestBody Note note) {
        notesService.updateNote(noteId, taskId, note);
        return ResponseEntity.accepted().body(new SuccessResponse("Note with id: "+ noteId + " updated successfully"));
    }
    @ExceptionHandler({NotesService.NoteNotFoundException.class, TasksService.TaskNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        return new ResponseEntity<>(
                new ErrorResponse(exception.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
