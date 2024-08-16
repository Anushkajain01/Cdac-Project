package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.PetServicesEntity;

@Repository
public interface PetServiceRepo extends JpaRepository<PetServicesEntity, Integer> {
    // Custom query methods can be defined here if needed
}
