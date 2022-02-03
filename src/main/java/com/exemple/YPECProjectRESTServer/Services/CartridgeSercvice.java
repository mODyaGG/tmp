package com.exemple.YPECProjectRESTServer.Services;

import com.exemple.YPECProjectRESTServer.Entitys.*;
import com.exemple.YPECProjectRESTServer.Repositorys.CartrigeRepository;
import com.exemple.YPECProjectRESTServer.Repositorys.TypeCarrtrigeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartridgeSercvice {
    @Autowired
    private final CartrigeRepository cartrigeRepository;
    @Autowired
    private final TypeCarrtrigeRepository typeCarrtrigeRepository;

    public CartridgeSercvice(CartrigeRepository cartrigeRepository, TypeCarrtrigeRepository typeCartridge) {
        this.cartrigeRepository = cartrigeRepository;
        this.typeCarrtrigeRepository = typeCartridge;
    }
    public List<Cartridge> list(){
        return cartrigeRepository.findAll();
    }

    public Cartridge addPrinter(Cartridge cartridge){
        TypeCartridge typeCartridge = typeCarrtrigeRepository.findById(cartridge.getType().getName()).orElse(null);
        if(typeCartridge != null) {
            cartridge.setType(typeCartridge);
            cartrigeRepository.save(cartridge);
            return cartridge;
        }
        else
            return null;
    }
    public Cartridge getOne(Cartridge cartridge){
        return cartrigeRepository.findById(cartridge.getUiid()).orElse(null);
    }
    public List<Cartridge> getInActive(){
        return cartrigeRepository.findActivePrinter();
    }

    public Cartridge edit(Cartridge cartridge){
        return cartrigeRepository.save(cartridge);
    }

    public void delete(Cartridge cartridge){
        cartrigeRepository.deleteById(cartridge.getUiid());
    }
}
