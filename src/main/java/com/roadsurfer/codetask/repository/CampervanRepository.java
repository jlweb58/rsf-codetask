package com.roadsurfer.codetask.repository;

import com.roadsurfer.codetask.model.Campervan;
import org.springframework.data.repository.CrudRepository;

public interface CampervanRepository extends CrudRepository<Campervan, Long> {

    Campervan findByName(String name);

    Campervan findByPlateNumber(String plateNumber);
}
