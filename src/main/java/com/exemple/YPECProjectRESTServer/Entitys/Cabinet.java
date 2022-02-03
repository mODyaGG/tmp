package com.exemple.YPECProjectRESTServer.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;
import java.util.List;

@Entity
@Table(catalog = "Test",schema = "dbo",name = "Cabinet")
public class Cabinet {

    @Id
    @Column(name = "uiid",nullable = false)
    private final String uiid = UUID.randomUUID().toString();
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name="id"),name = "id_housing",nullable = false)
    Housing housing;
    @OneToMany(targetEntity = CabinetWithPrinter.class
            , fetch = FetchType.LAZY
            , mappedBy = "cabinet"
            , cascade = CascadeType.ALL)
    @JsonIgnore
    List<CabinetWithPrinter> CabinetWithPrinterList;

    public Cabinet() {
    }

    public Cabinet(String name, String description, Housing housing) {
        this.name = name;
        this.description = description;
        this.housing = housing;
    }
    public List<CabinetWithPrinter> getCartridgeForPrinterList() {
        return CabinetWithPrinterList;
    }

    public void setCartridgeForPrinterList(List<CabinetWithPrinter> cartridgeForPrinterList) {
        this.CabinetWithPrinterList = cartridgeForPrinterList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }
}
