package com.roadsurfer.codetask.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
public class Equipment extends AbstractPersistable<Long> {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_type_id")
    private EquipmentType equipmentType;

    @OneToOne
    private RentalOrder rentalOrder;

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public RentalOrder getOrder() {
        return rentalOrder;
    }

    public void setOrder(RentalOrder rentalOrder) {
        this.rentalOrder = rentalOrder;
    }
}
