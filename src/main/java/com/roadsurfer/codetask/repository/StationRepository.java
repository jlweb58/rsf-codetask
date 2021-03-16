package com.roadsurfer.codetask.repository;

import com.roadsurfer.codetask.model.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {

    Station findByName(String name);
}
