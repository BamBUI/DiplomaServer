package com.psuti.Server.controller;



import com.psuti.Server.dao.EventsRepository;
import com.psuti.Server.entity.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/events")
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false")
public class EventsRestController {

    private final EventsRepository eventsRepository;

    @Autowired
    public EventsRestController(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @GetMapping
    public List<Events> getAll(){
        return eventsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Events getById (@PathVariable("id") UUID id){
        return eventsRepository.findById(id).get();
    }

    @PutMapping
    public Events update (@RequestBody Events events){
        if(eventsRepository.existsById (events.getId())) {
            return eventsRepository.save(events);
        }
        throw new EntityExistsException("Event with id:'"+ events.getId() +"' doesn't exist");
    }

    @PostMapping
    public Events create(@RequestBody Events events){
        return eventsRepository.save(events);
    }

    @DeleteMapping("/{id}")
    public void remove (@PathVariable("id") UUID id){
        eventsRepository.deleteById(id);
    }
}
