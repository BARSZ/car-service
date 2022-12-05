package com.project.cscb869.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auto_service")
public class AutoService extends BaseEntity {
    @OneToMany(targetEntity = Worker.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "service_fk", referencedColumnName = "id")
    private List<Worker> workers;
}
