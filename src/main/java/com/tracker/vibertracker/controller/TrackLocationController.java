package com.tracker.vibertracker.controller;

import com.tracker.vibertracker.model.TrackLocation;
import com.tracker.vibertracker.model.Walk;
import com.tracker.vibertracker.service.TrackLocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrackLocationController {

    private final TrackLocationService trackLocationService;

    public TrackLocationController(TrackLocationService trackLocationService) {
        this.trackLocationService = trackLocationService;
    }

    @GetMapping("/locations")
    public List<TrackLocation> getAllLocations() {
        return trackLocationService.getAll();
    }

    @GetMapping("/walks")
    public List<Walk> getAllWalks() {
        return trackLocationService.getWalks();
    }

}
