package com.exemple.YPECProjectRESTServer.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(catalog = "Test",schema = "dbo",name = "Cartridge")
public class Cartridge {
    @Id
    @Column(name = "uiid", unique = true, nullable = false)
    final private String uiid =  UUID.randomUUID().toString();

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "name"), name = "id_type", nullable = false)
    private TypeCartridge type;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = TypeStatus.class)
    @JoinColumn(foreignKey = @ForeignKey(name = "id_status_cartridge"),
            name = "id_status",nullable = true)
    private TypeStatus id_status;

    @Column(name = "cost", nullable = false)
    private String cost;

    @OneToMany(targetEntity = Printer.class,fetch = FetchType.LAZY
            ,mappedBy = "uiidCartridge",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Printer> printers;

    @OneToMany(targetEntity = Artifact.class, fetch = FetchType.LAZY, mappedBy = "cartridge",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cartridge> cartridgeList;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})



    public Cartridge() {
    }

    public Cartridge(String name, TypeCartridge type, String cost) {
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public Cartridge(String name, TypeCartridge type, TypeStatus id_status, String cost, List<Printer> printers, List<Cartridge> cartridgeList) {
        this.name = name;
        this.type = type;
        this.id_status = id_status;
        this.cost = cost;
        this.printers = printers;
    }

    public TypeStatus getId_status() {
        return id_status;
    }

    public void setId_status(TypeStatus id_status) {
        this.id_status = id_status;
    }

    public List<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(List<Printer> printers) {
        this.printers = printers;
    }

    public List<Cartridge> getCartridgeList() {
        return cartridgeList;
    }

    public void setCartridgeList(List<Cartridge> cartridgeList) {
        this.cartridgeList = cartridgeList;
    }

    public String getUiid() {
        return uiid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeCartridge getType() {
        return type;
    }

    public void setType(TypeCartridge type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
