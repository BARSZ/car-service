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
public class Service extends BaseEntity {
    @OneToMany(targetEntity = Worker.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "service_fk", referencedColumnName = "id")
    private List<Worker> workers;
}
