package com.csstreamer.DOA;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Locale;

import com.csstreamer.constants.DatabaseConstants;
import com.csstreamer.constants.ApplicationConstants;
import com.csstreamer.entities.Devices;
import com.csstreamer.utils.CSStreamerDB;

public class Devices_DAO {
	private static Devices_DAO devicesDao;
	private static CSStreamerDB CSStreamerDB;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (devicesDao != null) {
			CSStreamerDB = null;
		}
	}

	public static synchronized Devices_DAO getInstance() {
		try {
			if (devicesDao == null) {
				devicesDao = new Devices_DAO();
				CSStreamerDB = com.csstreamer.utils.CSStreamerDB.getInstance();
			}
			devicesDao.OpenDatabase();
		} catch (Exception ex) {
			devicesDao = null;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());
		}

		return devicesDao;
	}

	private boolean OpenDatabase() {
		boolean isDatabaseOpened = false;
		try {
			if (CSStreamerDB == null) {
				CSStreamerDB = com.csstreamer.utils.CSStreamerDB.getInstance();
				isDatabaseOpened = CSStreamerDB.isOpen();
			} else {
				isDatabaseOpened = CSStreamerDB.isOpen();
			}
		} catch (Exception ex) {
			isDatabaseOpened = false;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());
		}
		return isDatabaseOpened;
	}

	public boolean initializeTable() {
		boolean isInitialized = false;

		try {
			if (OpenDatabase()) {
				CSStreamerDB.getConnection().createStatement().execute("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_DEVICES);
				CSStreamerDB.getConnection().createStatement().execute(DatabaseConstants.CREATE_DEVICES_TABLE);
				CSStreamerDB.getConnection().createStatement().execute(DatabaseConstants.UNQ_DEVICE_NAME);
				isInitialized = true;
			} else {
				isInitialized = false;
				Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("DatabaseCannotBeOpened"));
			}
        } catch (SQLException sqlException) {
        	isInitialized = false;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("SQLExceptionError") + " : " + sqlException.getMessage());
        } catch (Exception ex) {
        	isInitialized = false;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
        }

		return isInitialized;
	}

	/*********************************
	 * ADD A NEW DEVICE
	 *********************************/

	public boolean create(Devices device) {
		boolean isCreated = false;

		try {
			if (OpenDatabase()) {
				PreparedStatement preparedStatement = setDeviceRecord(device, DatabaseConstants.INSERT_METHOD);

				if (preparedStatement != null) {

					if (preparedStatement.execute()) {
						isCreated = true;
					}
				}
			}
        } catch (SQLException sqlException) {
        	isCreated = false;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("SQLExceptionError") + " : " + sqlException.getMessage());
        } catch (Exception ex) {
        	isCreated = false;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
        }

		return isCreated;
	}

	/***************************************
	 * UPDATE EXISTING DEVICE
	 ***************************************/
	public boolean edit(Devices device) {
		boolean isEdited = false;

		try {
			if (OpenDatabase()) {
				PreparedStatement preparedStatement = setDeviceRecord(device, DatabaseConstants.EDIT_METHOD);

				if (preparedStatement != null) {

					if (preparedStatement.execute()) {
						isEdited = true;
					}
				}
			}
        } catch (SQLException sqlException) {
        	isEdited = false;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("SQLExceptionError") + " : " + sqlException.getMessage());
        } catch (Exception ex) {
        	isEdited = false;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
        }

		return isEdited;
	}

	/***************************************
	 * DELETE EXISTING DEVICE
	 ****************************************/
	public boolean remove(Devices device) {
		boolean isRemoved = false;

		try {
        } catch (Exception ex) {
        	isRemoved = false;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
        }

		return isRemoved;
	}

	/***************************************
	 * DELETE ALL EXISTING DEVICES
	 ****************************************/
	public boolean removeAll() {
		boolean isRemoveAll = false;

		try {
        } catch (Exception ex) {
        	isRemoveAll = false;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
        }

		return isRemoveAll;
	}

	/**********************************
	 * FIND DEVICE WITH ID
	 ***********************************/
	public Devices find(String deviceId) {
		Devices device = null;

		try {
        } catch (Exception ex) {
        	device = null;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
        }

		return device;
	}

	/*******************************
	 * GET ALL DEVICES
	 ********************************/
	public ArrayList<Devices> findAll() {
		ArrayList<Devices> listDevices = null;

		try {
        } catch (Exception ex) {
        	listDevices = null;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
        }

		return listDevices;
	}


	/**********************************************
	 * SETUP DEVICE ENTITY FROM FIELD
	 ***********************************************/
	private Devices setDeviceEntity() {
		Devices device = new Devices();

		try {
        } catch (Exception ex) {
        	device = null;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());        	
        }

		return device;
	}

	private PreparedStatement setDeviceRecord(Devices device, int method) {
		PreparedStatement preparedStatement = null;

		try {

			// PRIMARY KEY MUST NOT BE NULL
			if (device.getDeviceId() != null) {

				// PRIMARY KEY MUST NOT BE EMPTY
				if (!device.getDeviceId().isEmpty()) {

					// PREPARE THE SQL REQUEST
					if (method == DatabaseConstants.INSERT_METHOD) {
						preparedStatement = CSStreamerDB.getConnection().prepareStatement(DatabaseConstants.INSERT_DEVICE);
					}

					if (method == DatabaseConstants.EDIT_METHOD) {
						preparedStatement = CSStreamerDB.getConnection().prepareStatement(DatabaseConstants.EDIT_DEVICE);
						
						if (preparedStatement != null) {
							preparedStatement.setString(DatabaseConstants.POS_DEVICE_ID_WHERE, device.getDeviceId());
						}
					}

					// SETUP SQL FIELDS
					if (preparedStatement != null) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
						preparedStatement.setString(DatabaseConstants.POS_DEVICE_ID, device.getDeviceId());
						preparedStatement.setString(DatabaseConstants.POS_DEVICE_NAME, device.getDeviceName());
						preparedStatement.setString(DatabaseConstants.POS_DEVICE_SERIAL_NUMBER, device.getDeviceSerialNumber());

						if (device.getDeviceBuyDate() != null) {
							preparedStatement.setString(DatabaseConstants.POS_DEVICE_BUY_DATE, dateFormat.format(device.getDeviceBuyDate()));
						} else {
							preparedStatement.setString(DatabaseConstants.POS_DEVICE_BUY_DATE, null);
						}

						if (device.getDeviceProductionDate() != null) {
							preparedStatement.setString(DatabaseConstants.POS_DEVICE_PRODUCTION_DATE, dateFormat.format(device.getDeviceProductionDate()));
						} else {
							preparedStatement.setString(DatabaseConstants.POS_DEVICE_PRODUCTION_DATE, null);
						}

						preparedStatement.setString(DatabaseConstants.POS_DEVICE_SELECTED_TIMEZONE, device.getDeviceSelectedTimezone());
						preparedStatement.setString(DatabaseConstants.POS_DEVICE_COMMENT, device.getDeviceComment());
						preparedStatement.setInt(DatabaseConstants.POS_DEVICE_STATUS, device.getDeviceStatus());
						preparedStatement.setInt(DatabaseConstants.POS_DEVICE_VERSION, device.getDeviceVersion());
					}
				}
			}
		} catch (Exception ex) {
			preparedStatement = null;
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());
		}

		return preparedStatement;
	}

}