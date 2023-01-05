package com.project.cscb869.data.model;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Client;
import com.project.cscb869.data.entity.ServiceHistory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CarModel {
    @NotBlank
    @Size(min = 4, max = 8, message = "Min 4 Max 8")
    private String registrationNum;
    @NotBlank
    @Size(min = 3, max = 6, message = "Min 3 Max 6")
    private String model;
    @NotBlank
    @Size(min = 4, max = 4, message = "Min 4 Max 4")
    private int productionYear;

    private List<ServiceHistory> serviceHistories = new ArrayList<>();
    @NotBlank
    private Client client;
    private AutoService autoService;
}
