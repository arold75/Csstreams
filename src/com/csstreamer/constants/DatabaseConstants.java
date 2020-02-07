package com.csstreamer.constants;

public class DatabaseConstants {
    /******************************************************************/
    /*                                                                */
    /*                     DATABASE CONSTANTS                         */
    /*                                                                */
    /******************************************************************/

	// JDBC DATABASE CLASS
	public static final String JDBC_DATABASE_CLASS = "org.sqlite.JDBC";
	
	// DATABASE URL
	public static final String DATABASE_URL = "jdbc:sqlite:";

	// DATABASE MAXIMUM RETRY CONNECTION
    public static final int DATABASE_MAX_CONNECTION_RETRY = 1;

    // DATABASE NAME
    public static final String DATABASE_NAME = "CSStreamer_DB";

    // DATABASE VERSION
    public static final int DATABASE_VERSION = 1;
    
    // INSERT METHOD
    public static final int INSERT_METHOD = 1;
    
    // SELECT METHOD
    public static final int SELECT_METHOD = 2;

    // EDIT METHOD
    public static final int EDIT_METHOD = 3;

    // DELETE METHOD
    public static final int DELETE_METHOD = 4;

    /******************************************/
    /*           DEVICES TABLE                */
    /******************************************/
    // DEVICES TABLE
    public static final String TABLE_DEVICES = "DEVICES";

    // COLUMN NAME OF TABLE DEVICES
    public static final String COL_DEVICE_ID = "DEVICE_ID";
    public static final String COL_DEVICE_NAME = "DEVICE_NAME";
    public static final String COL_DEVICE_SERIAL_NUMBER = "DEVICE_SERIAL_NUMBER";
    public static final String COL_DEVICE_BUY_DATE = "DEVICE_BUY_DATE";
    public static final String COL_DEVICE_PRODUCTION_DATE = "DEVICE_PRODUCTION_DATE";
    public static final String COL_DEVICE_SELECTED_TIMEZONE = "DEVICE_SELECTED_TIMEZONE";
    public static final String COL_DEVICE_COMMENT = "DEVICE_COMMENT";
    public static final String COL_DEVICE_STATUS = "DEVICE_STATUS";
    public static final String COL_DEVICE_VERSION = "DEVICE_VERSION";

    // COLUMN NAME OF TABLE DEVICES
    public static final int POS_DEVICE_ID = 1;
    public static final int POS_DEVICE_NAME = 2;
    public static final int POS_DEVICE_SERIAL_NUMBER = 3;
    public static final int POS_DEVICE_BUY_DATE = 4;
    public static final int POS_DEVICE_PRODUCTION_DATE = 5;
    public static final int POS_DEVICE_SELECTED_TIMEZONE = 6;
    public static final int POS_DEVICE_COMMENT = 7;
    public static final int POS_DEVICE_STATUS = 8;
    public static final int POS_DEVICE_VERSION = 9;
    public static final int POS_DEVICE_ID_WHERE = 10;

    // COLUMS
    public static final String[] COLUMNS_DEVICES = {
            COL_DEVICE_ID,
            COL_DEVICE_NAME,
            COL_DEVICE_SERIAL_NUMBER,
            COL_DEVICE_BUY_DATE,
            COL_DEVICE_PRODUCTION_DATE,
            COL_DEVICE_SELECTED_TIMEZONE,
            COL_DEVICE_COMMENT,
            COL_DEVICE_STATUS,
            COL_DEVICE_VERSION,
    };

    // SQL STATEMENT FOR CREATION OF TABLE DEVICES
    public static final String CREATE_DEVICES_TABLE =
            "CREATE TABLE " + TABLE_DEVICES + " ( " +
                    COL_DEVICE_ID + " TEXT NOT NULL UNIQUE, " +
                    COL_DEVICE_NAME + " TEXT NOT NULL UNIQUE, " +
                    COL_DEVICE_SERIAL_NUMBER + " TEXT, " +
                    COL_DEVICE_BUY_DATE + " TEXT, " +
                    COL_DEVICE_PRODUCTION_DATE + " TEXT, " +
                    COL_DEVICE_SELECTED_TIMEZONE + " TEXT NOT NULL, " +
                    COL_DEVICE_COMMENT + " TEXT, " +
                    COL_DEVICE_STATUS + " INTEGER NOT NULL, " +
                    COL_DEVICE_VERSION + " INTEGER NOT NULL," +
                    "PRIMARY KEY (" + COL_DEVICE_ID + ")";
    
    public static final String UNQ_DEVICE_NAME =
            "CREATE UNIQUE INDEX UNQ_DEVICE_NAME ON " + TABLE_DEVICES + " (" + COL_DEVICE_NAME + " ASC);";

    public static final String INSERT_DEVICE = "INSERT INTO " + TABLE_DEVICES + " VALUES(?,?,?,?,?,?,?,?,?)";
    
    public static final String EDIT_DEVICE = "UPDATE " + TABLE_DEVICES 
    		+ " SET " + COL_DEVICE_ID + " = ? , "
    		+ " SET " + COL_DEVICE_NAME + " = ? , "
    		+ " SET " + COL_DEVICE_SERIAL_NUMBER + " = ? , "
    		+ " SET " + COL_DEVICE_BUY_DATE + " = ? , "
    		+ " SET " + COL_DEVICE_PRODUCTION_DATE + " = ? , "
    		+ " SET " + COL_DEVICE_SELECTED_TIMEZONE + " = ? , "
    		+ " SET " + COL_DEVICE_COMMENT + " = ? , "
    		+ " SET " + COL_DEVICE_STATUS + " = ? , "
    		+ " SET " + COL_DEVICE_VERSION + " = ? "
    		+ " WHERE " + COL_DEVICE_ID + " = ?";
    
    public static final String DELETE_DEVICE = "DELETE FROM " + TABLE_DEVICES + " WHERE " + COL_DEVICE_ID + " = ?";

}
