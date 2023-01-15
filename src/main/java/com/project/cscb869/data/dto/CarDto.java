package com.project.cscb869.data.dto;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Client;
import com.project.cscb869.data.entity.ServiceHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CarDto {
    private long id;
    private String registrationNum;
    private String model;
    private int productionYear;
    private List<ServiceHistory> serviceHistories = new ArrayList<>();
    private Client client;
    private AutoService autoService;
}
