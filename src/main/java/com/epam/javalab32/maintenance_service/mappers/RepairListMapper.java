package com.epam.javalab32.maintenance_service.mappers;

import com.epam.javalab32.maintenance_service.dto.RepairDto;
import com.epam.javalab32.maintenance_service.model.Repair;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepairListMapper {
    List<RepairDto> listRepairToRepairDto(List<Repair> repairs);
    List<Repair> listRepairDtoToRepair(List<RepairDto> repairsDto);
}
