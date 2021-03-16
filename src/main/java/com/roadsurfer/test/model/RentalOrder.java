package com.roadsurfer.test.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class RentalOrder extends AbstractPersistable<Long> {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "startstationid", nullable = false)
    private Station startStation;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "endstationid", nullable = false)
    private Station endStation;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "campervanid", nullable = false)
    private Campervan campervan;

    @OneToMany()
    private List<Equipment> equipmentList;

    @Column(name = "startdate", nullable = false)
    private LocalDate startDate;

    @Column(name = "enddate", nullable = false)
    private LocalDate endDate;

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    public Campervan getCampervan() {
        return campervan;
    }

    public void setCampervan(Campervan campervan) {
        this.campervan = campervan;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
