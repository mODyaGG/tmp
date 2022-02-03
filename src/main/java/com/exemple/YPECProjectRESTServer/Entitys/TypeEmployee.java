package com.exemple.YPECProjectRESTServer.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "Test",schema = "dbo", name = "TypeEmployee")
public class TypeEmployee {

    @Id
    private String id_type;
    @OneToMany(targetEntity = Employee.class
            , fetch = FetchType.LAZY
            , mappedBy = "typeEmployee"
            , cascade = CascadeType.ALL
            , orphanRemoval = true
    )
    @JsonIgnore
    List<Employee> employees;

    public TypeEmployee() {
    }

    public TypeEmployee(String id_type) {
        this.id_type = id_type;
    }

    public TypeEmployee(String id_type, List<Employee> employees) {
        this.id_type = id_type;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }
}
