package com.roadsurfer.codetask.controller;

import com.roadsurfer.codetask.model.Equipment;
import com.roadsurfer.codetask.model.RentalOrder;
import com.roadsurfer.codetask.model.Station;
import com.roadsurfer.codetask.repository.EquipmentRepository;
import com.roadsurfer.codetask.repository.RentalOrderRepository;
import com.roadsurfer.codetask.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private RentalOrderRepository rentalOrderRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping()
    public ResponseEntity<List<Station>> listAll() {
        Iterable<Station> stations = stationRepository.findAll();
        return ResponseEntity.ok(StreamSupport.stream(stations.spliterator(), false)
                .collect(Collectors.toList()));
    }

    @GetMapping(path = "/{stationId}")
    public ResponseEntity<List<Equipment>> getPickedUpEquipmentByDay(@PathVariable long stationId, @RequestParam
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        Station station = stationRepository.findById(stationId).get();

        List<RentalOrder> rentalOrders= rentalOrderRepository.findByStartStationAndStartDate(station, startDate);
        List<Equipment> allEquipment = rentalOrders.stream().flatMap(ro -> ro.getEquipmentList().stream()).collect(Collectors.toList());
        return ResponseEntity.ok(allEquipment);
    }

}
