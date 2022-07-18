package com.epam.javalab32.maintenance_service.dto;

import com.epam.javalab32.maintenance_service.dto.group.OnCreate;
import com.epam.javalab32.maintenance_service.dto.group.OnUpdate;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Timestamp;

@Data
public class RepairDto {
    private Long repairId;
    @PositiveOrZero(message = "Repair sum can't be less than 0")
    private double repairSum;
    @NotBlank(message = "Description shouldn't be empty")
    private String description;
    @FutureOrPresent(message = "Repair DateTime shouldn't be in past")
    private Timestamp repairDateTime;
    @Positive
    private int count;
    private Long repairedCarId;
}
