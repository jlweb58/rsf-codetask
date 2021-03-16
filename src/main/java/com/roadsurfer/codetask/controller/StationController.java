package com.roadsurfer.codetask.controller;

import com.roadsurfer.codetask.model.Station;
import com.roadsurfer.codetask.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationRepository stationRepository;

    @GetMapping()
    public ResponseEntity<List<Station>> listAll() {
        Iterable<Station> stations = stationRepository.findAll();
        return ResponseEntity.ok(StreamSupport.stream(stations.spliterator(), false)
                .collect(Collectors.toList()));
    }

}
