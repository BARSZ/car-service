package com.project.cscb869.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClientDto {
    private String name;
    private List<CarDto> cars = new ArrayList<>();
}
