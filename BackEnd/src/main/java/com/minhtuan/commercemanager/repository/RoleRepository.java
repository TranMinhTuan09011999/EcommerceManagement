package com.minhtuan.commercemanager.repository;

import java.util.Optional;

import com.minhtuan.commercemanager.model.ERole;
import com.minhtuan.commercemanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
