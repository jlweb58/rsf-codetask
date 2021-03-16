package com.roadsurfer.test.repository;

import com.roadsurfer.test.model.Campervan;
import org.springframework.data.repository.CrudRepository;

public interface CampervanRepository extends CrudRepository<Campervan, Long> {

    Campervan findByName(String name);

    Campervan findByPlateNumber(String plateNumber);
}
