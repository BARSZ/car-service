package com.project.cscb869.data.model;

import com.project.cscb869.data.entity.Car;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClientModel {
    @NotBlank
    @Size(min = 1, max = 20, message = "Between 1 and 20 characters please!")
    private String name;
    private List<Car> cars = new ArrayList<>();
}
