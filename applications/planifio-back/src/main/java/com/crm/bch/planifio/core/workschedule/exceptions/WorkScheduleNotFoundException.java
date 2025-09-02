package com.crm.bch.planifio.core.workschedule.exceptions;

public class WorkScheduleNotFoundException extends RuntimeException {

    private final String workScheduleId;

    public WorkScheduleNotFoundException(String workScheduleId) {
        super("WorkSchedule not found with id: " + workScheduleId);
        this.workScheduleId = workScheduleId;
    }

    public String getWorkScheduleId() {
        return workScheduleId;
    }
}