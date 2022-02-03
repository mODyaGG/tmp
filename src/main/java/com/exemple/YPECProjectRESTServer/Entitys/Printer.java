package com.exemple.YPECProjectRESTServer.Entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(catalog = "Test", schema = "dbo", name = "Printer")
public class Printer {
    @Id
    @Column(name = "uiid", unique = true, nullable = false)
    final private String uiid = UUID.randomUUID().toString();

    @Column(name = "name_printer", length = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "uuid"),
            name = "uiid_cartridge")
    private Cartridge uiidCartridge;

    @Column(name = "model", length = 255)
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "type_id"),
            name = "type_id", nullable = false)
    private TypePrinter typePrinter;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = TypeStatus.class)
    @JoinColumn(foreignKey = @ForeignKey(name = "id_status_for_printer"),
            name = "id_status",nullable = false)
    private TypeStatus id_status;

    @OneToMany(targetEntity = CartridgeForPrinter.class
            , fetch = FetchType.LAZY
            , mappedBy = "printer"
            , cascade = CascadeType.ALL)
    @JsonIgnore
    List<CartridgeForPrinter> cartridgeForPrinterList;

    @OneToMany(targetEntity = CabinetWithPrinter.class,fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,mappedBy = "printer")
    @JsonIgnore
    List<CabinetWithPrinter> cabinets;

    @OneToMany(targetEntity = Artifact.class,fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "printer")
    @JsonIgnore
    List<Artifact> artifacts;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})


    public Printer() {
    }

    public Printer(String name, Cartridge uiidCartridge,
                    String model,
                   TypePrinter typePrinter, TypeStatus id_status) {
        this.name = name;
        this.uiidCartridge = uiidCartridge;
        this.model = model;
        this.typePrinter = typePrinter;
        this.id_status = id_status;
    }




//    public List<Artifact> getPrinters() {
//        return artifacts;
//    }

    public TypeStatus getId_status() {
        return id_status;
    }

    public void setId_status(TypeStatus id_status) {
        this.id_status = id_status;
    }

    public void setPrinters(List<Artifact> printers) {
        this.artifacts = printers;
    }

//    public List<CartridgeForPrinter> getCartridgeForPrinterList() {
//        return cartridgeForPrinterList;
//    }

    public void setCartridgeForPrinterList(List<CartridgeForPrinter> cartridgeForPrinterList) {
        this.cartridgeForPrinterList = cartridgeForPrinterList;
    }

//    public List<CabinetWithPrinter> getCabinets() {
//        return cabinets;
//    }

    public void setCabinets(List<CabinetWithPrinter> cabinets) {
        this.cabinets = cabinets;
    }

    public TypePrinter getTypePrinter() {
        return typePrinter;
    }

    public void setTypePrinter(TypePrinter typePrinter) {
        this.typePrinter = typePrinter;
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

    public Cartridge getUiidCartridge() {
        return uiidCartridge;
    }

    public void setUiidCartridge(Cartridge uiidCartridge) {
        this.uiidCartridge = uiidCartridge;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}
