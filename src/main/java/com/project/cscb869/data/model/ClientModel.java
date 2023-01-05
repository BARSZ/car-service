package com.project.cscb869.data.model;

import com.project.cscb869.data.entity.Car;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClientModel {
    @NotBlank
    private String name;
    private List<Car> cars = new ArrayList<>();
}
