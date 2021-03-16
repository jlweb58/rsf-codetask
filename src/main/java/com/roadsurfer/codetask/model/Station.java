package com.roadsurfer.codetask.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Station extends AbstractPersistable<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany()
    @JoinColumn(name = "station_id")
    private final List<Equipment> equipmentInventory;

    public Station() {
        super();
        this.equipmentInventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEquipmentToInventory(Equipment equipment) {
        equipmentInventory.add(equipment);
    }

    public List<Equipment> getEquipmentInventory() {
        return Collections.unmodifiableList(equipmentInventory);
    }

    public void removeEquipmentFromInventory(Equipment equipment) {
            equipmentInventory.remove(equipment);
    }
}
