package com.psuti.Server.service.DiplomaService;

import com.psuti.Server.entity.Crowd;


import java.util.List;
import java.util.UUID;

public interface CrowdCrudService {
    Crowd create(Crowd crowd);
    Crowd update(Crowd crowd, UUID id);
    void removeById(UUID id);
    void remove(Crowd crowd);
    List<Crowd> getAll();
    Crowd getById(UUID id);

}

