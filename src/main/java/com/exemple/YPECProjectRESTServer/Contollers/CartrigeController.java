package com.exemple.YPECProjectRESTServer.Contollers;

import com.exemple.YPECProjectRESTServer.Entitys.Cartridge;
import com.exemple.YPECProjectRESTServer.Services.CartridgeSercvice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cartridge")
public class CartrigeController implements IController<Cartridge> {
    @Autowired
    private final CartridgeSercvice cartridgeSercvice;

    public CartrigeController(CartridgeSercvice cartridgeSercvice) {
        this.cartridgeSercvice = cartridgeSercvice;
    }

    /**
     * Get all cartridges list from DataBase
     *
     * @return JSON message containing all cartridges
     */
    @GetMapping
    public List<Cartridge> list() {
        return cartridgeSercvice.list();
    }

    /**
     * Getting all inactive cartridges
     *
     * @return JSON message received inactive cartridges
     */
    @GetMapping("/inactive")
    public List<Cartridge> inActiveList() {
        return cartridgeSercvice.getInActive();
    }

    /**
     * Getting a cartridge by id.
     *
     * @param cartridge
     * @return JSON message received cartridge
     */
    @GetMapping("{uuid}")
    public Cartridge getOne(@PathVariable("uuid") Cartridge cartridge) {
        return cartridgeSercvice.getOne(cartridge);
    }

    /**
     * Add new cartridge
     *
     * @param cartridge A JSON message a new cartridge
     * @return 200 if SUCCESS, 400 if a fail
     */
    @PostMapping
    public HttpStatus create(@Validated @RequestBody Cartridge cartridge) {
        return cartridgeSercvice.addPrinter(cartridge) != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    /**
     * Update the exist cartridge.
     *
     * @param cartridgeFromDb exist a cartridge in a DataBase
     * @param cartridge       Changed a cartridge
     * @return A message about a cartridge with new changed
     */
    @PutMapping("{uiid}")
    public Cartridge update(
            @PathVariable("uiid") Cartridge cartridgeFromDb,
            @RequestBody Cartridge cartridge
    ) {
        BeanUtils.copyProperties(cartridge, cartridgeFromDb, "uiid");
        return cartridgeSercvice.edit(cartridgeFromDb);
    }

    /**
     * Delete the exist cartridge.
     *
     * @param cartridge uiid the exist cartridge
     * @return 200 if the SUCCESS or
     * 400 if fail
     */
    @DeleteMapping("{uiid}")
    public HttpStatus delete(@PathVariable("uiid") Cartridge cartridge) {
        try {
            cartridgeSercvice.delete(cartridge);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

}
