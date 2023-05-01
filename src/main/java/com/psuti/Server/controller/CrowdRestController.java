package com.psuti.Server.controller;


import com.psuti.Server.dao.CrowdRepository;
import com.psuti.Server.entity.Crowd;
import com.psuti.Server.entity.Events;
import com.psuti.Server.service.DiplomaService.CrowdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/crowd")
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false")
public class CrowdRestController {

    private final CrowdRepository crowdRepository;

    @Autowired
    CrowdService crowdService;

    @Autowired
    public CrowdRestController(CrowdRepository crowdRepository) {
        this.crowdRepository = crowdRepository;
    }

    @GetMapping
    public List<Crowd> getAll(){
        return crowdRepository.findAll();
    }

    @GetMapping("/events/{events}")
    public List<Crowd> getCrowd(@PathVariable("events")Events events){
        return crowdRepository.findByEvents(events);
    }


    @GetMapping("/id/{id}")
    public Crowd getById (@PathVariable("id") UUID id){
        return crowdRepository.findById(id).get();
    }


    @PutMapping
    public Crowd update (@RequestBody Crowd crowd){
        if(crowdRepository.existsById (crowd.getId())) {
            return crowdRepository.save(crowd);
        }
        throw new EntityExistsException("Crowd with id:'"+ crowd.getId() +"' doesn't exist");
    }

    @PostMapping
    public Crowd create(@RequestBody Crowd crowd){
        return crowdRepository.save(crowd);
    }

    @DeleteMapping("/{id}")
    public void remove (@PathVariable("id") UUID id){
        crowdRepository.deleteById(id);
    }
}
