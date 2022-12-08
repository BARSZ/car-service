package com.project.cscb869.data.dto;

import com.project.cscb869.data.entity.Worker;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class AutoServiceDto {
    private String name;
    private List<Worker> workers;
}
