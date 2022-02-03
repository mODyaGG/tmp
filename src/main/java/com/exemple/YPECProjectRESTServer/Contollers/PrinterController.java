package com.exemple.YPECProjectRESTServer.Contollers;

import com.exemple.YPECProjectRESTServer.Entitys.Printer;
import com.exemple.YPECProjectRESTServer.Services.PrinterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("printer")
public class PrinterController {
    private final PrinterService printerService;

    @Autowired
    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }

    /**
     * Get all printers list from DataBase
     *
     * @return JSON message containing all printers
     */
    @GetMapping
    public List<Printer> list() {
        return printerService.list();
    }

    /**
     * Getting all inactive printers
     *
     * @return JSON message received inactive printers
     */
    @GetMapping("inactive")
    public List<Printer> getInactive() {
        return printerService.getInActive();
    }

    /**
     * Getting a printer by id.
     *
     * @param printer object from request body
     * @return JSON message received printer
     */
    @GetMapping("{uuid}")
    public Printer getOne(@PathVariable("uuid") Printer printer) {
        return printerService.getOne(printer);
    }

    /**
     * Add new printer
     *
     * @param printer A JSON message a new printer
     * @return 200 if SUCCESS, 400 if a fail
     */
    @PostMapping
    public HttpStatus create(@Validated @RequestBody Printer printer) {
        return printerService.addPrinter(printer) != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

    }
    /**
     * Update the exist printer.
     *
     * @param printerFromDb exist a printer in a DataBase
     * @param printer       Changed a printer
     * @return A message about a printer with new changed
     */
    @PutMapping("{uiid}")
    public Printer update(
            @PathVariable("uiid") Printer printerFromDb,
            @RequestBody Printer printer
    ) {
        BeanUtils.copyProperties(printer, printerFromDb, "uiid");
        return printerService.edit(printerFromDb);
    }
    /**
     * Delete the exist printer.
     * @param printer uiid the exist printer
     * @return 200 if the SUCCESS or
     *         400 if fail
     */
    @DeleteMapping("{uiid}")
    public HttpStatus delete(@PathVariable("uiid") Printer printer) {
        try {
            printerService.delete(printer);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

}
