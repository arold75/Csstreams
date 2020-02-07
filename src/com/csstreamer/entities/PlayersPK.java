package com.csstreamer.entities;

public class PlayersPK {
    private long playerId;
    private String playerDeviceId;

    public PlayersPK() {
    }

    public PlayersPK(long playerId, String playerDeviceId) {
        this.playerId = playerId;
        this.playerDeviceId = playerDeviceId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerDeviceId() {
        return playerDeviceId;
    }

    public void setPlayerDeviceId(String playerDeviceId) {
        this.playerDeviceId = playerDeviceId;
    }
}
