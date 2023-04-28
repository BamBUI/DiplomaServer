package com.psuti.Server.controller;


import com.psuti.Server.dao.CrowdRepository;
import com.psuti.Server.entity.Crowd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/userEvents")
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false")
public class CrowdRestController {

    private final CrowdRepository crowdRepository;

    @Autowired
    public CrowdRestController(CrowdRepository crowdRepository) {
        this.crowdRepository = crowdRepository;
    }
        
    @GetMapping
    public List<Crowd> getAll(){
        return crowdRepository.findAll();
    }

    @GetMapping("/{id}")
    public Crowd getById (@PathVariable("id") UUID id){
        return crowdRepository.findById(id).get();
    }

    @PutMapping
    public Crowd update (@RequestBody Crowd crowd){
        if(crowdRepository.existsById (crowd.getId())) {
            return crowdRepository.save(crowd);
        }
        throw new EntityExistsException("User Event with id:'"+ crowd.getId() +"' doesn't exist");
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
