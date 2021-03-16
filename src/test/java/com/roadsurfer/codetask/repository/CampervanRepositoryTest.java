package com.roadsurfer.codetask.repository;

import com.roadsurfer.codetask.model.Campervan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Transactional
public class CampervanRepositoryTest {

    @Autowired
    private CampervanRepository repository;

    @Test
    public void testCreateAndFind() {
        Campervan campervan = new Campervan();
        campervan.setName("Bulli");
        campervan.setPlateNumber("M RC 1111");
        campervan = repository.save(campervan);
        assertNotNull(campervan);
        Campervan found1 = repository.findByName("Bulli");
        assertNotNull(found1);
        Campervan found2 = repository.findByPlateNumber("M RC 1111");
        assertNotNull(found2);
    }

}
