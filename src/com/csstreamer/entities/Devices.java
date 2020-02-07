package com.csstreamer.entities;
import java.util.Date;

public class Devices {
    private String deviceId;
    private String deviceName;
    private String deviceSerialNumber;
    private Date deviceBuyDate;
    private Date deviceProductionDate;
    private String deviceSelectedTimezone;
    private String deviceComment;
    private int deviceConnectable;
    private int deviceStatus;
    private int deviceVersion;

    public Devices() {
    }

    public Devices(String deviceId) {
        this.deviceId = deviceId;
    }

    public Devices(String deviceId, String deviceName, String deviceSelectedTimezone, int deviceConnectable, int deviceStatus, int deviceVersion) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceSelectedTimezone = deviceSelectedTimezone;
        this.deviceConnectable = deviceConnectable;
        this.deviceStatus = deviceStatus;
        this.deviceVersion = deviceVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public Date getDeviceBuyDate() {
        return deviceBuyDate;
    }

    public void setDeviceBuyDate(Date deviceBuyDate) {
        this.deviceBuyDate = deviceBuyDate;
    }

    public Date getDeviceProductionDate() {
        return deviceProductionDate;
    }

    public void setDeviceProductionDate(Date deviceProductionDate) {
        this.deviceProductionDate = deviceProductionDate;
    }

    public String getDeviceSelectedTimezone() {
        return deviceSelectedTimezone;
    }

    public void setDeviceSelectedTimezone(String deviceSelectedTimezone) {
        this.deviceSelectedTimezone = deviceSelectedTimezone;
    }

    public int getDeviceConnectable() {
        return deviceConnectable;
    }

    public void setDeviceConnectable(int deviceConnectable) {
        this.deviceConnectable = deviceConnectable;
    }

    public String getDeviceComment() {
        return deviceComment;
    }

    public void setDeviceComment(String deviceComment) {
        this.deviceComment = deviceComment;
    }

    public int getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(int deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public int getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(int deviceVersion) {
        this.deviceVersion = deviceVersion;
    }
}
