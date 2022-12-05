package com.project.cscb869.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToMany(mappedBy = "autoService")
    @JsonIgnoreProperties("auto_service")
    private List<Worker> workers;

}
