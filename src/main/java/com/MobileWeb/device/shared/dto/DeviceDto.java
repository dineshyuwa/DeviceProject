package com.MobileWeb.device.shared.dto;

import java.io.Serializable;

public class DeviceDto implements Serializable {

    private String name;
    private String model;
    private String status;
    private String enrolledTime;
    private long deviceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnrolledTime() {
        return enrolledTime;
    }

    public void setEnrolledTime(String enrolledTime) {
        this.enrolledTime= enrolledTime;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }
}
