package com.psuti.Server.service.DiplomaService;

import com.psuti.Server.dao.CrowdRepository;
import com.psuti.Server.entity.Crowd;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class CrowdService implements CrowdCrudService {
    private final CrowdRepository crowdRepository;

    @Autowired
    public CrowdService(CrowdRepository crowdRepository){
        this.crowdRepository = crowdRepository;
    }

    @Override
    public Crowd create(Crowd crowd) {
        return crowdRepository.save(crowd);
    }

    public Crowd update(Crowd crowd, UUID id){
        if(!crowdRepository.existsById(id)) {
            throw new EntityExistsException("Crowd with id:'"+ crowd.getId() +"' doesn't exists");
        }
        return crowdRepository.save(crowd);
    }
    @Override
    public void removeById(UUID id) {
        crowdRepository.deleteById(id);
    }

    @Override
    public void remove(Crowd crowd) {
        crowdRepository.delete(crowd);
    }

    @Override
    public List<Crowd> getAll() {
        return crowdRepository.findAll();
    }

    @Override
    public Crowd getById(UUID id) {
        return crowdRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("Crowd with id: " + id + " doesn't exists");
        });
    }

}
