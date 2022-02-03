package com.exemple.YPECProjectRESTServer.Entitys;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(catalog = "Test",schema = "dbo", name = "CabinetWithPrinter")
public class CabinetWithPrinter {

    @Id
    @Column(name = "uiid",unique = true, nullable = false)
    private final String uiid = UUID.randomUUID().toString();
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Cabinet.class)
    @JoinColumn(foreignKey = @ForeignKey(name = "uiid_cabinet"),name = "uiid_cabinet",nullable = false)
    private Cabinet cabinet;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Printer.class)
    @JoinColumn(foreignKey = @ForeignKey(name = "uiid_printer"),name = "uiid_printer", nullable = false)
    private Printer printer;
    @Column(name="date_set")
    private final LocalDateTime date = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Employee.class)
    @JoinColumn(foreignKey = @ForeignKey(name = "who_set"),name="who_set",nullable = false)
    private Employee employee;


    public CabinetWithPrinter() {
    }


    public CabinetWithPrinter(Cabinet cabinet, Printer printer,Employee employee) {
        this.cabinet = cabinet;
        this.printer = printer;
    }
//
    public String getUiid() {
        return uiid;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public Employee getEmployee() {
        return employee;
    }
}
