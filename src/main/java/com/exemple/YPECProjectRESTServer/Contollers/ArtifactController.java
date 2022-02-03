package com.exemple.YPECProjectRESTServer.Contollers;

import com.exemple.YPECProjectRESTServer.Entitys.Artifact;
import com.exemple.YPECProjectRESTServer.Entitys.Cartridge;
import com.exemple.YPECProjectRESTServer.Entitys.Printer;
import com.exemple.YPECProjectRESTServer.Services.ArtifactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artifact")
public class ArtifactController implements IController<Artifact>{
    @Autowired
    private final ArtifactService artifactService;

    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }
    /**
     * Get all Artifact list from DataBase
     * @return JSON message containing all Artifact
     */
    @GetMapping
    public List<Artifact> list(){
        return artifactService.list();
    }

    @Override
    public Artifact getOne(Artifact object) {
        //TODO Доработать реализацию получения по id
        return null;
    }

    /**
     * Getting artifact using cartridge ID
     * @param cartridge object
     * @return JSON message containing all Artifact set a cartridge
     */
    @GetMapping(value = "/cartridge/{uiid}")
    public List<Artifact> getListCartridge(@PathVariable("uiid") Cartridge cartridge){
        return artifactService.getListByIdCartridge(cartridge);
    }

    /**
     * Getting artifact using printer ID
     * @param printer object from a request body
     * @return JSON message containing all Artifact set a printer
     */
    @GetMapping("/printer/{uiid}")
    public List<Artifact> getListPrinter(@PathVariable("uiid") Printer printer){
        return artifactService.getListByIdPrinter(printer);
    }
    /**
     * Add new artifact
     * @param artifact A JSON message a new artifact
     * @return 200 if SUCCESS, 400 if a fail
     */
    @PostMapping
    public HttpStatus create(@Validated @RequestBody Artifact artifact){
        return  artifactService.addArtifact(artifact) != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
    /**
     * Update the exist artifact.
     * @param artifactFromDb exist a artifact in a DataBase
     * @param artifact Changed a artifact
     * @return A message about a artifact with new changed
     */
    @PutMapping("{uiid}")
    public Artifact update(
            @PathVariable("uiid") Artifact artifactFromDb,
            @RequestBody Artifact artifact
    ){
        BeanUtils.copyProperties(artifact,artifactFromDb,"uiid");
        return artifactService.edit(artifactFromDb);
    }
    /**
     * Delete the exist artifact.
     * @param artifact uiid the exist artifact
     * @return 200 if the SUCCESS or
     *         400 if fail
     */
    @DeleteMapping("{uiid}")
    public HttpStatus delete(@PathVariable("uiid") Artifact artifact){
        try {
            artifactService.delete(artifact);
            return HttpStatus.OK;
        }
        catch (Exception e)     {
            return HttpStatus.BAD_REQUEST;
        }
    }

}
