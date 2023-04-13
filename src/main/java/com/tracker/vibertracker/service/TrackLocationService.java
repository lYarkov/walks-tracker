package com.tracker.vibertracker.service;

import com.tracker.vibertracker.model.TrackLocation;
import com.tracker.vibertracker.model.Walk;
import com.tracker.vibertracker.repository.TrackLocationRepo;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrackLocationService {
    private final TrackLocationRepo trackLocationRepo;

    public TrackLocationService(TrackLocationRepo trackLocationRepo) {
        this.trackLocationRepo = trackLocationRepo;
    }

    public List<TrackLocation> getAll() {
        return trackLocationRepo.findAll();
    }

    public List<TrackLocation> getAllOrderByDateTrack() {
        return trackLocationRepo.findAllOrderByDateTrack();
    }

    public List<Walk> getWalks() {
        List<TrackLocation> trackLocations = getAllOrderByDateTrack();
        List<Walk> walks = new ArrayList<>();

        Walk currentWalk = null;

        for (int i = 0; i < trackLocations.size() - 1; i++) {
            LocalDateTime currentDateTrack = trackLocations.get(i).getDateTrack().toLocalDateTime();
            LocalDateTime nextDateTrack = trackLocations.get(i + 1).getDateTrack().toLocalDateTime();
            Duration duration = Duration.between(currentDateTrack, nextDateTrack);

            if (i == 0) {
                currentWalk = new Walk();
                currentWalk.setBegin(currentDateTrack);
            } else if (duration.toMinutes() >= 30) {
                currentWalk.setEnd(currentDateTrack);
                currentWalk.setDuration();
                walks.add(currentWalk);
                currentWalk = new Walk();
                currentWalk.setBegin(nextDateTrack);
            }
        }
        return walks;
    }

}
