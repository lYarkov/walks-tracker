package com.tracker.vibertracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "TrackLocation")
@Getter
@Setter
public class TrackLocation {

    @Id
    private Integer id;

    @Column(name = "IMEI")
    private String imei;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longtitude;

    @Column(name = "date_event")
    private Timestamp dateEvent;

    @Column(name = "date_track")
    private Timestamp dateTrack;

    @Column(name = "type_source")
    private Integer typeSource;

}
