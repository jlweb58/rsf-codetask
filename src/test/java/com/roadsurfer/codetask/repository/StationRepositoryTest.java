package com.roadsurfer.codetask.repository;

import com.roadsurfer.codetask.model.Equipment;
import com.roadsurfer.codetask.model.EquipmentType;
import com.roadsurfer.codetask.model.Station;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Transactional
public class StationRepositoryTest {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @Autowired
    private StationRepository repository;

    @Test
    public void testIsNotNull() {
        assertNotNull(repository);
    }

    @Test
    public void testCreateAndFind() {
        Station station = new Station();
        station.setName("Munich");
        station = repository.save(station);
        assertNotNull(station.getId());
        Station found = repository.findByName("Munich");
        assertNotNull(found);
        assertEquals(station, found);
        assertNotNull(found.getEquipmentInventory());
    }

    @Test
    public void testAddRemoveEquipment() {
        Station station = new Station();
        EquipmentType equipmentType = new EquipmentType();
        equipmentType.setName("Camping table");
        equipmentTypeRepository.save(equipmentType);
        Equipment equipment = new Equipment();
        equipment.setEquipmentType(equipmentType);
        equipmentRepository.save(equipment);
        station.setName("Munich");
        station.addEquipmentToInventory(equipment);
        repository.save(station);
        Station found = repository.findByName("Munich");
        assertNotNull(found);
        assertNotNull(found.getEquipmentInventory());
        assertEquals(1, found.getEquipmentInventory().size());
        assertEquals(equipment, found.getEquipmentInventory().get(0));
    }

}
