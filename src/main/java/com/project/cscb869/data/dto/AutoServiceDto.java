package com.project.cscb869.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AutoServiceDto {
    private long id;
    private String name;
    private List<WorkerDto> workers = new ArrayList<>();
}
