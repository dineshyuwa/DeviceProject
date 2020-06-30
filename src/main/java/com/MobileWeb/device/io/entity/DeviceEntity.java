package com.MobileWeb.device.io.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="devices")
public class DeviceEntity implements Serializable {


    @Id
    @GeneratedValue
    private long deviceId;


    @Column(nullable =false,length=100)
    private String name;

    @Column(nullable=false,length=20)
    private String status;

    @Column(nullable = false,length=50)
    private String model;

    @Column(nullable=false,length=40)
    private String enrolledTime;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEnrolledTime() {
        return enrolledTime;
    }

    public void setEnrolledTime(String enrolledTime) {
        this.enrolledTime = enrolledTime;
    }

}
