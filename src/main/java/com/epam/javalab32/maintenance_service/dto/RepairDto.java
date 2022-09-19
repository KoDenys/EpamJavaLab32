package com.epam.javalab32.maintenance_service.dto;

import com.epam.javalab32.maintenance_service.model.Car;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RepairDto {
    private Long repairId;
    @PositiveOrZero(message = "Repair sum can't be less than 0")
    private double repairSum;
    @NotBlank(message = "Description shouldn't be empty")
    private String description;
    private Date repairDate;
    @Positive
    private int count;
    private Long carId;
    private Car car;
}
