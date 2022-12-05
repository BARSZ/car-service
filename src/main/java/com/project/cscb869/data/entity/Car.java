package com.project.cscb869.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    @JoinColumn(name = "car_fk", referencedColumnName = "id")
    private List<ServiceHistory> serviceHistories;
}
