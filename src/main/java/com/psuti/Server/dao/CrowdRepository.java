package com.psuti.Server.dao;

import com.psuti.Server.entity.Crowd;
import com.psuti.Server.entity.Events;
import com.psuti.Server.service.DiplomaService.CrowdProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.UUID;

public interface CrowdRepository extends JpaRepository <Crowd, UUID> {

    @Query( value = "SELECT u.teammate from Crowd u WHERE u.events =?1", nativeQuery = true)
    List<CrowdProjection> getAllCrowd(Events events);

    List<Crowd> findByEvents(Events events);
}
