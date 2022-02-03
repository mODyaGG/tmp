package com.exemple.YPECProjectRESTServer.Entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "Test",schema = "dbo",name = "Housing")
public class Housing {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name= "description",nullable = false)
    private String description;
    @OneToMany(targetEntity = Cabinet.class
            ,fetch = FetchType.LAZY,orphanRemoval = true
            ,cascade = CascadeType.ALL
            ,mappedBy = "housing")
    @JsonIgnore
    List<Cabinet> audiences;

    public Housing() {
    }

    public Housing(String id ,String description) {
        this.id = id;
        this.description = description;
    }

    public Housing(String id, String description,List<Cabinet> audiences) {
        this.id = id;
        this.audiences = audiences;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Cabinet> getAudiences() {
        return audiences;
    }

    public void setAudiences(List<Cabinet> audiences) {
        this.audiences = audiences;
    }
}
