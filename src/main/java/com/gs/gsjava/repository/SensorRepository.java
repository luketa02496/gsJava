package com.gs.gsjava.repository;

import com.gs.gsjava.model.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Page<Sensor> findByStatus(String status, Pageable pageable);
    
    long countByStatus(String status);

}


