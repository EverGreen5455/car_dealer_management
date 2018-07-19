package com.netcracker.server.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "manager")
public class Manager implements Serializable {

    @Id
    @Column(name = "manager_id", nullable = false)
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long managerId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "phone", nullable = false)
    private String phone;
}
