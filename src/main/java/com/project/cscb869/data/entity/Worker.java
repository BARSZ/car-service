package com.project.cscb869.data.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Worker extends BaseEntity{
    private ServiceType qualification;
}
