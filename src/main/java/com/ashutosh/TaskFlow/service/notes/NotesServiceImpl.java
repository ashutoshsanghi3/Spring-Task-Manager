package com.ashutosh.TaskFlow.service.notes;


import com.ashutosh.TaskFlow.model.Note;
import com.ashutosh.TaskFlow.model.Task;
import com.ashutosh.TaskFlow.repo.NotesRepo;
import com.ashutosh.TaskFlow.repo.TasksRepo;
import com.ashutosh.TaskFlow.service.tasks.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesRepo notesRepo;

    @Autowired
    private TasksRepo tasksRepo;
    @Autowired
    private TasksService tasksService;

    @Override
    public List<Note> getNotesByTaskId(int taskId) {
        Task task = tasksService.getTaskById(taskId);
        return notesRepo.findByTask(task);
    }

    @Override
    public Note getNoteByIdAndTaskId(int id, int taskId) {
        Task task = tasksService.getTaskById(taskId);
        if(task == null){
            throw new TasksService.TaskNotFoundException(taskId);
        }
        Note note = notesRepo.findByIdAndTask(id,task);
        if(note == null){
            throw new NoteNotFoundException(id);
        }
        return note;
    }


    @Override
    public void createNoteForTaskId(int taskId, Note note) {
        Task task = tasksService.getTaskById(taskId);
        note.setTask(task);
        notesRepo.save(note);
    }

    @Override
    public void deleteNote(int id, int taskId){
        Task task = tasksService.getTaskById(taskId);
        Note note = notesRepo.findByIdAndTask(id, task);
        if(note == null){
            throw new NoteNotFoundException(id);
        }
        notesRepo.delete(note);
    }
    @Override
    public void updateNote(int id, int taskId, Note note){
        Task task = tasksService.getTaskById(taskId);
        note.setId(id);
        note.setTask(task);
        notesRepo.save(note);
    }
    @Override
    public void deleteNotes(int taskId) {
        Task task = tasksService.getTaskById(taskId);
        List<Note> notes = notesRepo.findByTask(task);
        notesRepo.deleteAll(notes);
    }
}
