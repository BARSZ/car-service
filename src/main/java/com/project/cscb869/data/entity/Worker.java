package com.project.cscb869.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "worker")
public class Worker extends BaseEntity{
    private ServiceType qualification;
    @ManyToOne
    @JoinColumn(name = "auto_service_id")
    @JsonBackReference
    private AutoService autoService;
}
