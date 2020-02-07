package com.csstreamer.constants;

public class ApplicationConstants {
    public static final String APPLICATION_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    public static final String APPLICATION_ROOT_PATH = "/Volumes/CSSTREAMER/";    
    public static final String DATABASE_PATH = "/DATABASE/";
    public static final String DATABASE_FULL_PATH = (APPLICATION_ROOT_PATH + DATABASE_PATH).replace("//", "/");
    
    public static final String LOGFILES_PATH = "/LOGFILES/";
    public static final String LOGFILES_FULL_PATH = (APPLICATION_ROOT_PATH + LOGFILES_PATH).replace("//", "/");
    
    public static final String MEDIAFILES_PATH = "/MEDIAFILES/";
    public static final String MEDIAFILES_FULL_PATH = (APPLICATION_ROOT_PATH + MEDIAFILES_PATH).replace("//", "/");
    
    public static final String IMAGES_PATH = "/IMAGES/";
    public static final String IMAGES_FULL_PATH = (APPLICATION_ROOT_PATH + IMAGES_PATH).replace("//", "/");
    public static final String NOIMAGE = "noimage.png";
    public static final String NOPERSON = "noperson.jpg";
    
    public static final String SYSTEM_LOGGER_NAME = "CSStreamerLogSystem";
    public static final String PLAYER_LOGGER_NAME = "CSStreamerLogPlayer";
    public static final String SYNC_LOGGER_NAME = "CSStreamerLogSync";
    public static final String ERROR_LOGGER_NAME = "CSStreamerLogError";
    public static final String NET_LOGGER_NAME = "CSStreamerLogNet";
    

    public static enum PersistAction {
        CREATE,
        DELETE,
        UPDATE,
        DESTROY
    }

    /******************************************/
    /*             RECORDS STATUSES           */
    /******************************************/


    public static final int STATUS_NONE = 0;
    public static final int STATUS_NEW = 1;
    public static final int STATUS_MODIFIED = 2;
    public static final int STATUS_MARK_DELETED = 4;
    public static final int STATUS_DESYNCHRONISED = 8;
    public static final int STATUS_UNDELETABLE = 16;
    public static final int STATUS_UNALTERABLE = 32;
    public static final int STATUS_UNVISIBLE = 64;
    

}
