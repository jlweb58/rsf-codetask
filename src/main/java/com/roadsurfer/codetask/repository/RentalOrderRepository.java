package com.roadsurfer.codetask.repository;

import com.roadsurfer.codetask.model.RentalOrder;
import com.roadsurfer.codetask.model.Station;
import org.springframework.boot.autoconfigure.web.reactive.function.client.ReactorNettyHttpClientMapper;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentalOrderRepository extends CrudRepository<RentalOrder, Long> {

    List<RentalOrder> findByStartStationAndStartDate(Station station, LocalDate startDate);
}
