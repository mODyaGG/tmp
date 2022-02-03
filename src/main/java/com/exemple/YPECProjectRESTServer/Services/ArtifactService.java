package com.exemple.YPECProjectRESTServer.Services;

import com.exemple.YPECProjectRESTServer.Entitys.*;
import com.exemple.YPECProjectRESTServer.Repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtifactService {
    @Autowired
    private final ArtifactRepository artifactRepository;
    private final CartrigeRepository cartrigeRepository;
    private final PrinterRepository printerRepository;
    private final EmployeeRepository employeeRepository;
    private final TypeArtifactRepository typeArtifactRepository;


    public ArtifactService(
            ArtifactRepository artifactRepository,
            CartrigeRepository cartrigeRepository,
            PrinterRepository printerRepository,
            EmployeeRepository employeeRepository,
            TypeArtifactRepository typeArtifactRepository) {
        this.artifactRepository = artifactRepository;
        this.cartrigeRepository = cartrigeRepository;
        this.printerRepository = printerRepository;
        this.employeeRepository = employeeRepository;
        this.typeArtifactRepository = typeArtifactRepository;
    }


    public List<Artifact> list(){
        return artifactRepository.findAll();
    }

    public List<Artifact> getListByIdPrinter(Printer printer){
        return artifactRepository.findByPrinterId(printer.getUiid());
    }

    public List<Artifact> getListByIdCartridge(Cartridge cartridge){
        return artifactRepository.findByIdCartridge(cartridge.getUiid());
    }

    public Artifact addArtifact(Artifact artifact){
        Printer printer = printerRepository.findById(artifact.getPrinter().getUiid()).orElse(null);
        Employee employee = employeeRepository.findById(artifact.getEmployee().getEmail()).orElse(null);
        Cartridge cartridge = cartrigeRepository.findById(artifact.getCartridge().getUiid()).orElse(null);
        TypeArtifact typeArtifact = typeArtifactRepository.findById(artifact.getId_type().getType_id()).orElse(null);
        if(printer != null &&
                employee != null &&
                cartridge != null &&
                typeArtifact != null){
            artifact.setEmployee(employee);
            artifact.setCartridge(cartridge);
            artifact.setPrinter(printer);
            return artifactRepository.save(artifact);
        }
        else
            return null;
    }
    public Artifact getOne(Artifact artifact){
        return artifactRepository.findById(artifact.getUiid()).orElse(null);
    }
    public Artifact edit(Artifact artifact){
        return artifactRepository.save(artifact);
    }
    public List<Artifact> getArtifactCartridge(String cartidge) {return artifactRepository.findByIdCartridge(cartidge);}
    public List<Artifact> getArtifactPrinter(String printer){return artifactRepository.findByPrinterId(printer);}
    public void delete(Artifact artifact){
        artifactRepository.deleteById(artifact.getUiid());
    }


}
