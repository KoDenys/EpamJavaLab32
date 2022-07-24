package com.epam.javalab32.maintenance_service.controller.model;

import com.epam.javalab32.maintenance_service.dto.RepairDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class RepairModel extends RepresentationModel<RepairModel> {
    @JsonUnwrapped
    private RepairDto repairDto;
}
