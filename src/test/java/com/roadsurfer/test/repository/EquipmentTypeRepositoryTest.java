package com.roadsurfer.test.repository;

import com.roadsurfer.test.model.EquipmentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Transactional
public class EquipmentTypeRepositoryTest {

    @Autowired
    private EquipmentTypeRepository repository;

    @Test
    public void testCreateAndFind() {
        EquipmentType equipmentType = new EquipmentType();
        equipmentType.setName("Camping Table");
        repository.save(equipmentType);
        EquipmentType found = repository.findById(equipmentType.getId()).get();
        assertNotNull(found);
    }

    @Test()
    public void testCreateDuplicateName() {
        EquipmentType equipmentType = new EquipmentType();
        equipmentType.setName("one");
        repository.save(equipmentType);
        EquipmentType duplicate = new EquipmentType();
        duplicate.setName("one");
        repository.save(duplicate);
    }

}
