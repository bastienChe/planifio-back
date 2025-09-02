package com.crm.bch.planifio.application.web.dto;

public enum Day {

    LUNDI(0),
    MARDI(1),
    MERCREDI(2),
    JEUDI(3),
    VENDREDI(4),
    SAMEDI(5),
    DIMANCHE(6);

    private final int value;

    Day(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Day fromInt(int value) {
        for (Day day : Day.values()) {
            if (day.value == value) return day;
        }
        throw new IllegalArgumentException("Invalid day value: " + value);
    }
}
