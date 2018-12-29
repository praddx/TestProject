package ru.plahotin.validation.meetingvalidation;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@TimeRange(startTime = "startTime", endTime = "endTime")
public class Meeting {

    private LocalTime startTime;
    private LocalTime endTime;
    @NotBlank
    private String address;
    private String comment;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
