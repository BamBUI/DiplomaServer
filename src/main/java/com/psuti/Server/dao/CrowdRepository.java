package com.psuti.Server.dao;


import com.psuti.Server.entity.Crowd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CrowdRepository extends JpaRepository <Crowd, UUID> {
}
