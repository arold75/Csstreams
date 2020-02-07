package com.csstreamer.processes;

public class MediaPlayer {

    // indicates the state our service:
    enum State {
        IDLE, // media player is not initialised
        BUFFERING, // media player is preparing...
        PLAYING, // playback active for local media (media player ready!)
        PAUSED, // playback paused (media player ready!)
        ENDED
    }

    private State statePlayer = State.IDLE;
	
    
    public void startPlayer() {
    	
    }
    
    public void haltPlayer() {
    	
    }
    
    public void stopPlayer() {
    	
    }
    
    public void playNextMedia() {
    	
    }
    
    private void selectNextMedia() {
    	
    }
    
    public void playPreviousMedia() {
    	
    }
    
    private void selectPreviousMedia() {
    	
    }
    
    public void playMedia() {
    	
    }
    
    private void startMedia() {
    	
    }
    
    public void pauseMedia() {
    	
    }
    
    public void seekMediaTo(long pos) {
    	
    }
    
    public long getCurrentMediaDuration() {
    	long currentMediaDuration = 0L;
    	
    	return currentMediaDuration;
    }
    
    public long getCurrentMusicPosition() {
        long currentPosition = 0;
        
        return currentPosition;
    }

    public void jumpToMedia(int selectedSong) {
    	
    }
    
    private void releaseResources() {
    	
    }
    
    private void managerPlayerError(String resquestor) {
    	
    }

}
