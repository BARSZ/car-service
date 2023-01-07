package com.project.cscb869.data.model;

import com.project.cscb869.data.dto.AutoServiceDto;
import com.project.cscb869.data.entity.ServiceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerModel {
    @NotBlank
    @Size(min = 1, max = 20, message = "Between 1 and 20 characters please!")
    private String name;
    private ServiceType qualification;
    private AutoServiceDto autoService;
}
