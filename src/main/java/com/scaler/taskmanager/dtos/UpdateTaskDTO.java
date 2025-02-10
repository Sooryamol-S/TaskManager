package com.scaler.taskmanager.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTaskDTO {

    String description;
    String deadline;
    Boolean status;
}
