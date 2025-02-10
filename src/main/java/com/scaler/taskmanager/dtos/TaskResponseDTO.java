package com.scaler.taskmanager.dtos;

import com.scaler.taskmanager.entities.NoteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {

    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean status;
    private List<NoteEntity> notes;
}
