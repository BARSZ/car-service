package com.project.cscb869.data.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "car_service_history")
public class ServiceHistory extends BaseEntity{
    private double price;
    private ServiceType serviceType;
}
