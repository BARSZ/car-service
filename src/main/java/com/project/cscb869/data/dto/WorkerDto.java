package com.project.cscb869.data.dto;

import com.project.cscb869.data.entity.ServiceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerDto {
    private long id;
    private String name;
    private ServiceType qualification;
    private AutoServiceDto autoService;
}
