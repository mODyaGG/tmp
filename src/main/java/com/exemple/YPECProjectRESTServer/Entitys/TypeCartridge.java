package com.exemple.YPECProjectRESTServer.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "Test",schema = "dbo", name="TypeCartridge")
public class TypeCartridge {
    @Id
    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @OneToMany(targetEntity = Cartridge.class,fetch = FetchType.LAZY
            ,mappedBy = "type",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cartridge> cartridges;

    public TypeCartridge() {
    }

    public TypeCartridge(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TypeCartridge(String name, String description, List<Cartridge> cartridges) {
        this.name = name;
        this.description = description;
        this.cartridges = cartridges;
    }

    public List<Cartridge> getCartridges() {
        return cartridges;
    }

    public void setCartridges(List<Cartridge> cartridges) {
        this.cartridges = cartridges;
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
}
