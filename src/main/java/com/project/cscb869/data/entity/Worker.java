package com.project.cscb869.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Worker extends BaseEntity{
    private ServiceType qualification;
    @ManyToOne(targetEntity = Service.class, cascade = CascadeType.ALL)
    private Service service;
}
