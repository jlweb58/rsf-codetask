package com.roadsurfer.test.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Campervan extends AbstractPersistable<Long> {
    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "platenumber", nullable = false)
    private String plateNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
