package com.tracker.vibertracker.repository;

import com.tracker.vibertracker.model.TrackLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackLocationRepo extends JpaRepository<TrackLocation, Integer> {

    @Query("select t from TrackLocation t order by t.dateTrack")
    List<TrackLocation> findAllOrderByDateTrack();

}
