package com.csstreamer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.csstreamer.constants.DatabaseConstants;
import com.csstreamer.constants.ApplicationConstants;

public class CSStreamerDB {
	private static CSStreamerDB CSStreamerDB;
	private Connection connection;
	
    public static synchronized CSStreamerDB getInstance(){
        if (CSStreamerDB == null) {
            CSStreamerDB = new CSStreamerDB();
        }

        return CSStreamerDB;
    }

    private CSStreamerDB() {
    	try {
            Class.forName(DatabaseConstants.JDBC_DATABASE_CLASS);
            connection = DriverManager.getConnection(DatabaseConstants.DATABASE_URL + (ApplicationConstants.DATABASE_FULL_PATH + "/" + DatabaseConstants.DATABASE_NAME).replace("//","/"));
    	} catch (ClassNotFoundException notFoundException) {
    		connection = null;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("NOTFoundException") + " : " + notFoundException.getMessage());
        } catch (SQLException sqlException) {
    		connection = null;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("SQLExceptionError") + " : " + sqlException.getMessage());
        } catch (Exception ex) {
    		connection = null;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
        }
    }

    public Connection getConnection() {
    	return this.connection;
    }
    
	public boolean isOpen() {
		boolean isOpened = false;

		try {
			if (this.connection != null) {
				if (this.connection.isValid(0)) {
					return true;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
		}

		return isOpened;
	}
    
    @Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		
		if(connection != null) {
			connection.close();
		}
	}

}