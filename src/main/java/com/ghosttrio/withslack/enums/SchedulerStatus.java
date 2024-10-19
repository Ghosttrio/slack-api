package com.ghosttrio.withslack.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SchedulerStatus {
    ON("스케줄러 ON"), OFF("스케줄러 OFF");
    private final String status;

    public String getStatus() {
        return status;
    }
}
