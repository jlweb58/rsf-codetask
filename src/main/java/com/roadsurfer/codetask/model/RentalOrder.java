package com.roadsurfer.codetask.model;

import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rental_order")
public class RentalOrder extends AbstractPersistable<Long> {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "start_station_id", nullable = false)
    private Station startStation;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "end_station_id", nullable = false)
    private Station endStation;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "campervan_id", nullable = false)
    private Campervan campervan;

    @OneToMany()
    private List<Equipment> equipmentList;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    public RentalOrder() {
        super();
    }

    public RentalOrder(Station startStation, Station endStation, Campervan campervan, LocalDate startDate, LocalDate endDate) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.campervan = campervan;
        this.startDate = startDate;
        this.endDate = endDate;
    }

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
