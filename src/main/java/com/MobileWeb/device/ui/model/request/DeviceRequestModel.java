package com.MobileWeb.device.ui.model.request;

public class DeviceRequestModel {
    private String name;
    private String model;
    private String status;
    private String enrolledTime;

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
        this.enrolledTime = enrolledTime;
    }
}
