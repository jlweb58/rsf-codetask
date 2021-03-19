package com.roadsurfer.codetask.repository;


import com.roadsurfer.codetask.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RentalOrderRepositoryTest {

    @Autowired
    private RentalOrderRepository repository;

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private CampervanRepository campervanRepository;

    private Equipment equipment1;
    private Equipment equipment2;
    private Station munich;
    private Station berlin;
    private Campervan campervan1;
    private Campervan campervan2;

    @BeforeEach
    public void setUp() {
        EquipmentType campingTable = makeEquipmentType("PingPong Table");
        EquipmentType bedding = makeEquipmentType("Dog Bed");
        equipment1 = makeEquipment(campingTable);
        equipment2 = makeEquipment(bedding);
        munich = makeStation("Munich");
        berlin = makeStation("Berlin");
        campervan1 = new Campervan();
        campervan1.setName("Bulli");
        campervan1.setPlateNumber("M RC 1111");
        campervan1 = campervanRepository.save(campervan1);
        campervan2 = new Campervan();
        campervan2.setName("Bulli");
        campervan2.setPlateNumber("M RC 1112");
        campervan2 = campervanRepository.save(campervan2);
    }

    @Test
    public void testCreateRentalOrder() {
        RentalOrder rentalOrder = new RentalOrder();
        rentalOrder.setCampervan(campervan1);
        rentalOrder.setStartStation(munich);
        rentalOrder.setEndStation(munich);
        rentalOrder.setStartDate(LocalDate.of(2021, 6, 30));
        rentalOrder.setEndDate(LocalDate.of(2021, 7, 10));
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        rentalOrder.setEquipmentList(equipmentList);
        RentalOrder created = repository.save(rentalOrder);
        assertNotNull(created);
        assertNotNull(rentalOrder.getCampervan());
        assertNotNull(rentalOrder.getEquipmentList());
        assertEquals(2, rentalOrder.getEquipmentList().size());
    }

    @Test
    public void testFindByStationAndStartDate() {
        RentalOrder rentalOrder = new RentalOrder();
        rentalOrder.setCampervan(campervan1);
        rentalOrder.setStartStation(munich);
        rentalOrder.setEndStation(munich);
        rentalOrder.setStartDate(LocalDate.of(2021, 6, 30));
        rentalOrder.setEndDate(LocalDate.of(2021, 7, 10));
        repository.save(rentalOrder);
        rentalOrder = new RentalOrder();
        rentalOrder.setCampervan(campervan2);
        rentalOrder.setStartStation(munich);
        rentalOrder.setEndStation(munich);
        rentalOrder.setStartDate(LocalDate.of(2021, 6, 30));
        rentalOrder.setEndDate(LocalDate.of(2021, 7, 10));
        repository.save(rentalOrder);

        List<RentalOrder> pickedUpOrders = repository.findByStartStationAndStartDate(munich, LocalDate.of(2021, 6, 30));
        assertNotNull(pickedUpOrders);
        assertEquals(2, pickedUpOrders.size());
    }

    private Station makeStation(String name) {
        Station station = new Station();
        station.setName(name);
        return stationRepository.save(station);
    }

    private Equipment makeEquipment(EquipmentType equipmentType) {
        Equipment equipment = new Equipment();
        equipment.setEquipmentType(equipmentType);
        return equipmentRepository.save(equipment);
    }

    private EquipmentType makeEquipmentType(String name) {
        EquipmentType equipmentType = new EquipmentType();
        equipmentType.setName(name);
        return equipmentTypeRepository.save(equipmentType);
    }

}
