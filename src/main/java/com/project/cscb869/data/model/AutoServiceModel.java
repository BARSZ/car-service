package com.project.cscb869.data.model;

import com.project.cscb869.data.entity.Worker;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AutoServiceModel {
    @NotBlank
    @Size(min = 3, max = 20, message = "Min 3 Max 20")
    private String name;
    private List<Worker> workers = new ArrayList<>();
}
