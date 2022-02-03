package com.exemple.YPECProjectRESTServer.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "Test",schema = "dbo",name = "TypeArtifact")
public class TypeArtifact {
    @Id
    @Column
    private String type_id;
    @OneToMany(targetEntity = Artifact.class,fetch = FetchType.LAZY,mappedBy = "id_type",cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Artifact> artifactList;

    public TypeArtifact() {
    }

    public TypeArtifact(String type_id) {
        this.type_id = type_id;
    }

    public List<Artifact> getArtifactList() {
        return artifactList;
    }

    public void setArtifactList(List<Artifact> artifactList) {
        this.artifactList = artifactList;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }
}
