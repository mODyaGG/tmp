package com.exemple.YPECProjectRESTServer.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "Test",schema = "dbo",name="TypePrinter")
public class TypePrinter {
    @Id
    @Column (name = "type_id")
    private String name;
    @Column (name = "description")
    private String description;
    @OneToMany(targetEntity = Printer.class
            , fetch = FetchType.LAZY
            , mappedBy = "typePrinter"
            , cascade = CascadeType.ALL
            ,orphanRemoval = true
    )
    @JsonIgnore
    private List<Printer> printerList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Printer> getPrinterList() {
        return printerList;
    }

    public void setPrinterList(List<Printer> printerList) {
        this.printerList = printerList;
    }

    public TypePrinter() {
    }

    public TypePrinter(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TypePrinter(String name, String description, List<Printer> printerList) {
        this.name = name;
        this.description = description;
        this.printerList = printerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
