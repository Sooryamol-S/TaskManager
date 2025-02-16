package com.scaler.taskmanager.controllers;

import com.scaler.taskmanager.dtos.CreateNoteDTO;
import com.scaler.taskmanager.dtos.CreateNoteResponseDTO;
import com.scaler.taskmanager.entities.NoteEntity;
import com.scaler.taskmanager.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
private NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId){
         var notes= noteService.getNotesForTask(taskId);

          return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNote(@PathVariable("taskId") Integer taskId, @RequestBody CreateNoteDTO body){
        var note= noteService.addNoteForTask(taskId,body.getTitle(),body.getBody());

        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId,note));
    }

}
