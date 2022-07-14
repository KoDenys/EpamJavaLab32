package com.epam.javalab32.maintenance_service.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class RepairDto {
    private Long repairId;
    private double repairSum;
    private String description;
    private Timestamp repairDateTime;
    private int count;
    private Long repairedCarId;
}
