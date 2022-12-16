package com.project.cscb869.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User usernameId;
}
