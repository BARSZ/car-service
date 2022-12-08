package com.project.cscb869.data.dto;

import com.project.cscb869.data.entity.ServiceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WorkerDto {
    private String name;
    private ServiceType qualification;
    private AutoServiceDto autoService;
}
