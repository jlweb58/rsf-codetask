package com.roadsurfer.codetask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
public class Equipment extends AbstractPersistable<Long> {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_type_id")
    private EquipmentType equipmentType;

    @OneToOne
    @JoinColumn(name = "rental_order_id", referencedColumnName = "id")
    private RentalOrder rentalOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Station station;

    public Equipment() {
        super();
    }

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

    public RentalOrder getRentalOrder() {
        return rentalOrder;
    }

    public void setRentalOrder(RentalOrder rentalOrder) {
        this.rentalOrder = rentalOrder;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
