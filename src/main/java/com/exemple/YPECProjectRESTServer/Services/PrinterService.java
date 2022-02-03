package com.exemple.YPECProjectRESTServer.Services;

import com.exemple.YPECProjectRESTServer.Entitys.Printer;
import com.exemple.YPECProjectRESTServer.Entitys.TypePrinter;
import com.exemple.YPECProjectRESTServer.Entitys.TypeStatus;
import com.exemple.YPECProjectRESTServer.Repositorys.PrinterRepository;
import com.exemple.YPECProjectRESTServer.Repositorys.TypePrinterRepository;
import com.exemple.YPECProjectRESTServer.Repositorys.TypeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrinterService {
    @Autowired
    PrinterRepository printerRepository;
    @Autowired
    TypePrinterRepository typePrinterRepository;
    @Autowired
    TypeStatusRepository typeStatusRepository;

    public PrinterService(PrinterRepository printerRepository,
                          TypePrinterRepository typePrinterRepository,
                          TypeStatusRepository typeStatusRepository) {
        this.printerRepository = printerRepository;
        this.typePrinterRepository = typePrinterRepository;
        this.typeStatusRepository = typeStatusRepository;
    }

    public List<Printer> list(){
        return printerRepository.findAll();
    }
    public List<Printer> getInActive(){return  printerRepository.findActivePrinter();}

    public Printer addPrinter(Printer printer){
        TypePrinter typePrinter = typePrinterRepository.findById(printer.getTypePrinter().getName()).orElse(null);
        TypeStatus typeStatus = typeStatusRepository.findById(printer.getId_status().getName()).orElse(null);
        if(typePrinter != null && typeStatus != null) {
            printer.setTypePrinter(typePrinter);
            printer.setId_status(typeStatus);
            printerRepository.save(printer);
            printer = printerRepository.findById(printer.getUiid()).orElse(null);
            return printer;
        }
        else
            return null;
    }
    public Printer getOne(Printer printer){
        return printerRepository.findById(printer.getUiid()).orElse(null);
    }

    public Printer edit(Printer printer){
        return printerRepository.save(printer);
    }

    public void delete(Printer printer){
        printerRepository.deleteById(printer.getUiid());
    }

}
