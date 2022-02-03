package com.exemple.YPECProjectRESTServer.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "Test",schema = "dbo",name = "TypeStatus")
public class TypeStatus {
    @Id
    private String name;
    @OneToMany(targetEntity = Printer.class,fetch = FetchType.LAZY,mappedBy = "id_status",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Printer> printerList;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(targetEntity = Cartridge.class,fetch = FetchType.LAZY,mappedBy = "id_status",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Cartridge> cartridgeList;
    public TypeStatus() {
    }

    public List<Cartridge> getCartridgeList() {
        return cartridgeList;
    }

    public void setCartridgeList(List<Cartridge> cartridgeList) {
        this.cartridgeList = cartridgeList;
    }

    public TypeStatus(String name) {
        this.name = name;
    }

    public List<Printer> getPrinterList() {
        return printerList;
    }

    public void setPrinterList(List<Printer> printerList) {
        this.printerList = printerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
