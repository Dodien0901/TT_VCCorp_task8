package com.dovn.employeem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "department")
@Getter
@Setter
public class Department {
    @Id
    private String id;
    @Column(name = "dep_name")
    private String name;
    @Column(name ="found_date")
    private LocalDate foundDate;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Employee> listEmployee;

}
