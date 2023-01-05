package com.project.cscb869.data.model;

import com.project.cscb869.data.dto.AutoServiceDto;
import com.project.cscb869.data.entity.ServiceType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerModel {
    @NotBlank
    private String name;
    @NotBlank
    private ServiceType qualification;

    private AutoServiceDto autoService;
}
