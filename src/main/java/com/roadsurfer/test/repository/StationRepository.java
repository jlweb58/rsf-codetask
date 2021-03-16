package com.roadsurfer.test.repository;

import com.roadsurfer.test.model.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {

    Station findByName(String name);
}
