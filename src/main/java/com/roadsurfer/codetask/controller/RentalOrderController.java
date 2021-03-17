package com.roadsurfer.codetask.controller;

import com.roadsurfer.codetask.model.Campervan;
import com.roadsurfer.codetask.model.RentalOrder;
import com.roadsurfer.codetask.model.Station;
import com.roadsurfer.codetask.repository.CampervanRepository;
import com.roadsurfer.codetask.repository.RentalOrderRepository;
import com.roadsurfer.codetask.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("rentalorders")
@Transactional
public class RentalOrderController {

    @Autowired
    private RentalOrderRepository rentalOrderRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private CampervanRepository campervanRepository;

    @GetMapping
    public ResponseEntity<List<RentalOrder>> listAll() {
        Iterable<RentalOrder> rentalOrders = rentalOrderRepository.findAll();
        return ResponseEntity.ok(StreamSupport.stream(rentalOrders.spliterator(), false)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<RentalOrder> create(@RequestBody RentalOrder rentalOrder) {
        RentalOrder newRentalOrder = new RentalOrder();
        Station startStation = stationRepository.findById(rentalOrder.getStartStation().getId()).get();
        Station endStation = stationRepository.findById(rentalOrder.getEndStation().getId()).get();
        Campervan campervan = campervanRepository.findById(rentalOrder.getCampervan().getId()).get();
        newRentalOrder.setCampervan(campervan);
        newRentalOrder.setStartStation(startStation);
        newRentalOrder.setEndStation(endStation);
        newRentalOrder.setStartDate(rentalOrder.getStartDate());
        newRentalOrder.setEndDate(rentalOrder.getEndDate());
        RentalOrder created = rentalOrderRepository.save(newRentalOrder);
        return ResponseEntity.ok(created);
    }

}
