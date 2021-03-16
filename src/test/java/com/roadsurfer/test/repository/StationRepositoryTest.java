package com.roadsurfer.test.repository;

import com.roadsurfer.test.model.Station;
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
    }

}
