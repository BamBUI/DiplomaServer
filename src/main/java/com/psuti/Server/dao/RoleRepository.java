package com.psuti.Server.dao;

import com.psuti.Server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, String> {
}
