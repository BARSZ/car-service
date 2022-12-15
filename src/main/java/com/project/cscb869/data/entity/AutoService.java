package com.project.cscb869.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auto_service")
public class AutoService extends BaseEntity {

    @OneToMany(mappedBy = "autoService")
    @JsonIgnoreProperties("auto_service")
    @JsonManagedReference
    private List<Worker> workers = new ArrayList<>();

    @OneToMany(mappedBy = "autoService")
    private List<Car> carsToBeServiced;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User usernameId;
}
