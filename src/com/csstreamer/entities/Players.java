package com.csstreamer.entities;

public class Players {
    protected PlayersPK playersPK;
    private String playerName;
    private String playerBroadcastIp;
    private Integer playerBroadcastPort;
    private String playerBroadcastUsername;
    private String playerBroadcastPassword;
    private String playerBroadcastMountPoint;
    private String playerOutputModule;
    private String playerModuleDevice;
    private int playerCrossfadeDurationSeconds;
    private int playerSeekoffsetSeconds;
    private int playerInitialVolumeLevel;
    private int playerStatus;
    private int playerVersion;
    private Devices devices;

    public Players() {
    }

    public Players(PlayersPK playersPK) {
        this.playersPK = playersPK;
    }

    public Players(PlayersPK playersPK, String playerName, int playerCrossfadeDurationSeconds, int playerSeekoffsetSeconds, int playerInitialVolumeLevel, int playerStatus, int playerVersion) {
        this.playersPK = playersPK;
        this.playerName = playerName;
        this.playerCrossfadeDurationSeconds = playerCrossfadeDurationSeconds;
        this.playerSeekoffsetSeconds = playerSeekoffsetSeconds;
        this.playerInitialVolumeLevel = playerInitialVolumeLevel;
        this.playerStatus = playerStatus;
        this.playerVersion = playerVersion;
    }

    public Players(long playerId, String playerDeviceId) {
        this.playersPK = new PlayersPK(playerId, playerDeviceId);
    }

    public PlayersPK getPlayersPK() {
        return playersPK;
    }

    public void setPlayersPK(PlayersPK playersPK) {
        this.playersPK = playersPK;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerBroadcastIp() {
        return playerBroadcastIp;
    }

    public void setPlayerBroadcastIp(String playerBroadcastIp) {
        this.playerBroadcastIp = playerBroadcastIp;
    }

    public Integer getPlayerBroadcastPort() {
        return playerBroadcastPort;
    }

    public void setPlayerBroadcastPort(Integer playerBroadcastPort) {
        this.playerBroadcastPort = playerBroadcastPort;
    }

    public String getPlayerBroadcastUsername() {
        return playerBroadcastUsername;
    }

    public void setPlayerBroadcastUsername(String playerBroadcastUsername) {
        this.playerBroadcastUsername = playerBroadcastUsername;
    }

    public String getPlayerBroadcastPassword() {
        return playerBroadcastPassword;
    }

    public void setPlayerBroadcastPassword(String playerBroadcastPassword) {
        this.playerBroadcastPassword = playerBroadcastPassword;
    }

    public String getPlayerBroadcastMountPoint() {
        return playerBroadcastMountPoint;
    }

    public void setPlayerBroadcastMountPoint(String playerBroadcastMountPoint) {
        this.playerBroadcastMountPoint = playerBroadcastMountPoint;
    }

    public String getPlayerOutputModule() {
        return playerOutputModule;
    }

    public void setPlayerOutputModule(String playerOutputModule) {
        this.playerOutputModule = playerOutputModule;
    }

    public String getPlayerModuleDevice() {
        return playerModuleDevice;
    }

    public void setPlayerModuleDevice(String playerModuleDevice) {
        this.playerModuleDevice = playerModuleDevice;
    }

    public int getPlayerCrossfadeDurationSeconds() {
        return playerCrossfadeDurationSeconds;
    }

    public void setPlayerCrossfadeDurationSeconds(int playerCrossfadeDurationSeconds) {
        this.playerCrossfadeDurationSeconds = playerCrossfadeDurationSeconds;
    }

    public int getPlayerSeekoffsetSeconds() {
        return playerSeekoffsetSeconds;
    }

    public void setPlayerSeekoffsetSeconds(int playerSeekoffsetSeconds) {
        this.playerSeekoffsetSeconds = playerSeekoffsetSeconds;
    }

    public int getPlayerInitialVolumeLevel() {
        return playerInitialVolumeLevel;
    }

    public void setPlayerInitialVolumeLevel(int playerInitialVolumeLevel) {
        this.playerInitialVolumeLevel = playerInitialVolumeLevel;
    }

    public int getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(int playerStatus) {
        this.playerStatus = playerStatus;
    }

    public int getPlayerVersion() {
        return playerVersion;
    }

    public void setPlayerVersion(int playerVersion) {
        this.playerVersion = playerVersion;
    }

    public Devices getDevices() {
        return devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }
}
