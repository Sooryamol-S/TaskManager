package com.scaler.taskmanager.controllers;

import com.scaler.taskmanager.dtos.CreateTaskDTO;
import com.scaler.taskmanager.dtos.ErrorResponseDTO;
import com.scaler.taskmanager.dtos.TaskResponseDTO;
import com.scaler.taskmanager.dtos.UpdateTaskDTO;
import com.scaler.taskmanager.entities.TaskEntity;
import com.scaler.taskmanager.service.NoteService;
import com.scaler.taskmanager.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TaskService taskService;
    private final NoteService noteService;
    private ModelMapper modelMapper= new ModelMapper();


    public TasksController(TaskService taskService, NoteService noteService) {
        this.taskService = taskService;
        this.noteService = noteService;
    }



    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
          var tasks=taskService.getTasks();

          return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable("id") Integer id){
        var task=taskService.getTaskById(id);
        var notes=noteService.getNotesForTask(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        var taskResponse= modelMapper.map(task, TaskResponseDTO.class);
        taskResponse.setNotes(notes);
        return ResponseEntity.ok(taskResponse);
    }
    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        var task=taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());

        return ResponseEntity.ok(task);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity>  updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO body) throws ParseException{
        var task= taskService.updateTask(id, body.getDescription(), body.getDeadline(), body.getStatus());
        if(task==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception e){
        if(e instanceof ParseException){
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid date format"));
        }
        e.printStackTrace();;
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
    }
}
