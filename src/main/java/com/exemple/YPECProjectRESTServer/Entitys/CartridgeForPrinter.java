package com.exemple.YPECProjectRESTServer.Entitys;

import javax.persistence.*;

@Entity
@Table(catalog = "Test", schema = "dbo",name ="CabinetForPrinter" )
public class CartridgeForPrinter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Printer.class)
    @JoinColumn(foreignKey = @ForeignKey(name = "id_printer"), name = "id_printer",nullable = false)
    private Printer printer;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Cartridge.class)
    @JoinColumn(foreignKey = @ForeignKey(name="id_cartridge"),name = "id_cartridge",nullable = false)
    private Cartridge cartridge;


    public CartridgeForPrinter() {
    }

    public CartridgeForPrinter(Printer printer, Cartridge cartridge) {
        this.printer = printer;
        this.cartridge = cartridge;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public Cartridge getCartridge() {
        return cartridge;
    }

    public void setCartridge(Cartridge cartridge) {
        this.cartridge = cartridge;
    }
}
