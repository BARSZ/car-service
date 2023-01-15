package com.project.cscb869.data.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarModel {
    @NotBlank
    @Size(min = 3, max = 6, message = "Min 3 Max 6")
    private String model;
    @NotBlank
    @Size(min = 4, max = 8, message = "Min 4 Max 8")
    private String registrationNum;

    private int productionYear;
}
