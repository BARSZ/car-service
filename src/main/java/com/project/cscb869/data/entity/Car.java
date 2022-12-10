package com.project.cscb869.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Car extends BaseEntity{
    private String registrationNum;
    private String model;
    private int productionYear;
    @OneToMany(targetEntity = ServiceHistory.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @JsonBackReference
    private List<ServiceHistory> serviceHistories;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "auto_service_id")
    private AutoService autoService;
}
