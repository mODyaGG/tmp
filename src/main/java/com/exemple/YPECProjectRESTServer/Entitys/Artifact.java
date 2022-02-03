package com.exemple.YPECProjectRESTServer.Entitys;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(catalog = "Test", schema = "dbo", name = "Artifact")
public class Artifact {

    @Id
    @Column(name = "uiid")
    private final String uiid = UUID.randomUUID().toString();
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Cartridge.class)
    @JoinColumn(foreignKey = @ForeignKey(name = "id_cartridge_for_artifact")
            ,name = "id_cartridge",nullable = false)
    private Cartridge cartridge;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Printer.class)
    @JoinColumn(foreignKey = @ForeignKey(name = "id_printer_for_artifact"), name = "id_printer",nullable = false)
    private Printer printer;
    @Column(name = "image", length = 10000,nullable = false)
    private String image;
    @Column(name = "description", length = 10000, nullable = false)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Employee.class)
    @JoinColumn(foreignKey = @ForeignKey(name = "who_set_for_artifact"),name="who_set",nullable = false)
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = TypeArtifact.class)
    @JoinColumn(foreignKey = @ForeignKey(name="type_artifact"),name = "type_id",nullable = false)
    private TypeArtifact id_type;


    public Artifact() {
    }

    public Artifact(Cartridge cartridge, Printer printer, String image,
                    String description, Employee employee, TypeArtifact id_type) {
        this.cartridge = cartridge;
        this.printer = printer;
        this.image = image;
        this.description = description;
        this.employee = employee;
        this.id_type = id_type;
    }

    public String getUiid() {
        return uiid;
    }

    public Cartridge getCartridge() {
        return cartridge;
    }

    public void setCartridge(Cartridge cartridge) {
        this.cartridge = cartridge;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TypeArtifact getId_type() {
        return id_type;
    }

    public void setId_type(TypeArtifact id_type) {
        this.id_type = id_type;
    }
}
