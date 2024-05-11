package com.ldrobot.bean;

import java.util.ArrayList;

public class SweepAppointmentList {
    private String timeZone;
    private String timeZoneSec;
    private ArrayList<SweepAppointment> value;

    public String getTimeZone() {
        return timeZone;
    }

    public String getTimeZoneSec() {
        return timeZoneSec;
    }

    public void setTimeZoneSec(String timeZoneSec) {
        this.timeZoneSec = timeZoneSec;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public ArrayList<SweepAppointment> getValue() {
        return value;
    }

    public void setValue(ArrayList<SweepAppointment> value) {
        this.value = value;
    }
}
