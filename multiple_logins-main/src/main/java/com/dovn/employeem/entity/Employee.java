package com.dovn.employeem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "employee")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "tel")
    private String tel;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Employee_Role", joinColumns = @JoinColumn(name = "employeeid"),
    inverseJoinColumns = @JoinColumn(name = "Roleid"))
    private Set<Role> listRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentId")
    private Department department;
}
