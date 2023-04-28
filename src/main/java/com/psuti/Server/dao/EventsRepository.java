package com.psuti.Server.dao;


import com.psuti.Server.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventsRepository extends JpaRepository <Events, UUID> {
}
