package com.epam.javalab32.maintenance_service.mappers;

import com.epam.javalab32.maintenance_service.dto.RepairDto;
import com.epam.javalab32.maintenance_service.model.Repair;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepairMapper {
    RepairMapper INSTANCE = Mappers.getMapper(RepairMapper.class);

    RepairDto repairToRepairDto(Repair repair);
    Repair repairDtoToRepair(RepairDto repairDto);
}
