package com.psuti.Server.service.DiplomaService;

import com.psuti.Server.dao.CrowdRepository;
import com.psuti.Server.entity.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CrowdService {
    @Autowired
    CrowdRepository crowdRepository;

    public List<CrowdProjection> getCrowd(Events events){return crowdRepository.getAllCrowd(events);}
}
