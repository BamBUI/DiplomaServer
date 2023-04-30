package com.psuti.Server.controller;


import com.psuti.Server.dao.CrowdRepository;
import com.psuti.Server.entity.Crowd;

import com.psuti.Server.service.DiplomaService.CrowdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RequestMapping("/crowd")
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false")
public class CrowdRestController {

    private final CrowdService crowdService;

    @Autowired
    public CrowdRestController(CrowdService crowdService) {
        this.crowdService = crowdService;
    }
        
    @GetMapping
    public List<Crowd> getAll(){
        return crowdService.getAll();
    }

    @GetMapping("/{id}")
    public Crowd getById (@PathVariable("id") UUID id){
        return crowdService.getById(id);
    }

    @PutMapping("/{id}")
    public Crowd update (Crowd crowd, @PathVariable("id") UUID id){
        return crowdService.update(crowd,id);
    }

    @PostMapping
    public Crowd create(@RequestBody Crowd crowd){
        return crowdService.create(crowd);
    }

    @DeleteMapping("/{id}")
    public void remove (@PathVariable("id") UUID id){
        crowdService.removeById(id);
    }

}
