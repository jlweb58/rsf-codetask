package com.roadsurfer.codetask.repository;

import com.roadsurfer.codetask.model.Equipment;
import com.roadsurfer.codetask.model.EquipmentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Transactional
public class EquipmentRepositoryTest {

    @Autowired
    private EquipmentRepository repository;

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @Test
    public void testCreateAndFind() {
        EquipmentType equipmentType = new EquipmentType();
        equipmentType.setName("Camping table");
        equipmentTypeRepository.save(equipmentType);
        Equipment equipment = new Equipment();
        equipment.setEquipmentType(equipmentType);
        repository.save(equipment);
        Equipment found = repository.findById(equipment.getId()).get();
        assertNotNull(found);
        assertNotNull(found.getEquipmentType());


    }

}
