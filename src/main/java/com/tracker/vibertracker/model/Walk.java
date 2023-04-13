package com.tracker.vibertracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Walk {

    private LocalDateTime begin;
    private LocalDateTime end;
    private Duration duration;

    public void setDuration() {
        if (begin != null && end != null) {
            duration = Duration.between(begin, end);
        }
    }

}
