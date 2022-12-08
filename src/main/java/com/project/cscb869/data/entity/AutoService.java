package com.project.cscb869.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
}
