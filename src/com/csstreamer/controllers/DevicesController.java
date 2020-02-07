package com.csstreamer.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.csstreamer.constants.ApplicationConstants;
import com.csstreamer.constants.DatabaseConstants;
import com.csstreamer.entities.Devices;
import com.csstreamer.sessions.DevicesFacade;
import com.csstreamer.utils.Messages;

public class DevicesController {
	private static String selectedDeviceId;
	private DevicesFacade ejbFacadeLocal = null;
	private Devices selected = null;
	private List<Devices> items = null;
	private Boolean isSilent = false;
	private Boolean isEmbeddableKeys = true;
	private Boolean isWebSyncRequested = true;

	public DevicesController() {
		ejbFacadeLocal = new DevicesFacade();

		try {
			if(ejbFacadeLocal != null) {
			}
		} catch (Exception ex) {
			selected = null;
		}
	}

	public boolean initializeTable() {
		return getFacadeLocal().initializeTable();
	}

	public Devices getSelected() {
		return selected;
	}

	public void setSelected(Devices selected) {
		this.selected = selected;
	}

	public boolean removeAllRows() {
		return getFacadeLocal().removeAll();
	}

	protected void setEmbeddableKeys() {
		selected.setDeviceVersion(selected.getDeviceVersion() + 1);
		selected.setDeviceStatus(selected.getDeviceStatus() | ApplicationConstants.STATUS_MODIFIED | ApplicationConstants.STATUS_DESYNCHRONISED);
	}

	protected void initializeEmbeddableKey() {
		selected.setDeviceVersion(0);
		selected.setDeviceStatus(ApplicationConstants.STATUS_NEW | ApplicationConstants.STATUS_DESYNCHRONISED);
	}

	private DevicesFacade getFacadeLocal() {
		return ejbFacadeLocal;
	}

	public Devices prepareCreate() {
		selected = new Devices();
		initializeEmbeddableKey();
		return selected;
	}

	public boolean create(Boolean silent, Boolean embeddableKeys, Boolean webSyncRequested) {
		if (webSyncRequested == null) {
			this.isWebSyncRequested = true;
		} else {
			this.isWebSyncRequested = webSyncRequested;
		}
		return this.create(silent, embeddableKeys);
	}

	public boolean create(Boolean silent, Boolean embeddableKeys) {
		if (silent == null) {
			this.isSilent = false;
		} else {
			this.isSilent = silent;
		}

		if (embeddableKeys == null) {
			this.isEmbeddableKeys = true;
		} else {
			this.isEmbeddableKeys = embeddableKeys;
		}

		return this.create();
	}

	public boolean update(Boolean silent, Boolean embeddableKeys, Boolean webSyncRequested) {
		if (webSyncRequested == null) {
			this.isWebSyncRequested = true;
		} else {
			this.isWebSyncRequested = webSyncRequested;
		}
		return this.update(silent, embeddableKeys);
	}

	public boolean update(Boolean silent, Boolean embeddableKeys) {
		if (silent == null) {
			this.isSilent = false;
		} else {
			this.isSilent = silent;
		}

		if (embeddableKeys == null) {
			this.isEmbeddableKeys = true;
		} else {
			this.isEmbeddableKeys = embeddableKeys;
		}

		return this.update();
	}

	public boolean delete(Boolean silent, Boolean embeddableKeys, Boolean webSyncRequested) {
		if (webSyncRequested == null) {
			this.isWebSyncRequested = true;
		} else {
			this.isWebSyncRequested = webSyncRequested;
		}
		return this.delete(silent, embeddableKeys);
	}

	public boolean delete(Boolean silent, Boolean embeddableKeys) {
		if (silent == null) {
			this.isSilent = false;
		} else {
			this.isSilent = silent;
		}

		if (embeddableKeys == null) {
			this.isEmbeddableKeys = true;
		} else {
			this.isEmbeddableKeys = embeddableKeys;
		}

		return this.delete();
	}

	public boolean destroy(Boolean silent, Boolean embeddableKeys, Boolean webSyncRequested) {
		if (webSyncRequested == null) {
			this.isWebSyncRequested = true;
		} else {
			this.isWebSyncRequested = webSyncRequested;
		}
		return this.destroy(silent, embeddableKeys);
	}

	public boolean destroy(Boolean silent, Boolean embeddableKeys) {
		if (silent == null) {
			this.isSilent = false;
		} else {
			this.isSilent = silent;
		}

		if (embeddableKeys == null) {
			this.isEmbeddableKeys = true;
		} else {
			this.isEmbeddableKeys = embeddableKeys;
		}

		return this.destroy();
	}

	public boolean create() {
		persist(ApplicationConstants.PersistAction.CREATE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("DevicesCreated"));
		if (!Messages.isValidationFailed()) {
			items = null; // Invalidate list of items to trigger re-query.
			return true;
		} else {
			return false;
		}
	}

	public boolean update() {
		persist(ApplicationConstants.PersistAction.UPDATE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("DevicesUpdated"));
		if (!Messages.isValidationFailed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delete() {
		persist(ApplicationConstants.PersistAction.DELETE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("DevicesDeleted"));
		if (!Messages.isValidationFailed()) {
			selected = null; // Remove selection
			items = null; // Invalidate list of items to trigger re-query.
			return true;
		} else {
			return false;
		}
	}

	public boolean destroy() {
		persist(ApplicationConstants.PersistAction.DESTROY, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("DevicesDeleted"));
		if (!Messages.isValidationFailed()) {
			selected = null; // Remove selection
			items = null; // Invalidate list of items to trigger re-query.
			return true;
		} else {
			return false;
		}
	}

	private void persist(ApplicationConstants.PersistAction persistAction, String successMessage) {
		try {
			if (selected != null) {
				if (this.isEmbeddableKeys) {
					setEmbeddableKeys();
				}
				
				if (persistAction == ApplicationConstants.PersistAction.CREATE) {
					Messages.setValidation(getFacadeLocal().create(selected));
					if (Messages.isValidation() && isWebSyncRequested) {
						// webSynchroManager.sendRow(DatabaseConstants.TABLE_DEVICES, selected);
					}
				}
				
				if (persistAction == ApplicationConstants.PersistAction.UPDATE) {
					Messages.setValidation(getFacadeLocal().edit(selected));
					if (!Messages.isValidation() && isWebSyncRequested) {
						// webSynchroManager.sendRow(DatabaseConstants.TABLE_DEVICES, selected);
					}
				}
				
				if (persistAction == ApplicationConstants.PersistAction.DELETE) {
					selected.setDeviceStatus(selected.getDeviceStatus() | ApplicationConstants.STATUS_MARK_DELETED | ApplicationConstants.STATUS_DESYNCHRONISED | ApplicationConstants.STATUS_UNVISIBLE);
					Messages.setValidation(getFacadeLocal().edit(selected));
					
					if (!Messages.isValidation() && isWebSyncRequested) {
						// webSynchroManager.sendRow(DatabaseConstants.TABLE_DEVICES, selected);
					}
				}
				
				if (persistAction == ApplicationConstants.PersistAction.DESTROY) {
					Messages.setValidation(getFacadeLocal().remove(selected));
				}
				
				if (Messages.isValidation()) {
					if (!this.isSilent) {
						Messages.addSuccessMessage(successMessage);
					}
				} else {
					if (!this.isSilent) {
						Messages.addErrorMessage(ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("PersistenceErrorOccured"));
					}
				}
				
				Logger.getLogger(ApplicationConstants.SYNC_LOGGER_NAME).log(Level.INFO, persistAction.toString() + ": " + selected.getDeviceName() + ". isValidationFailed: " + Messages.isValidation());
			}

		} catch (Exception ex) {
			Messages.setValidation(false);
			Logger.getLogger(ApplicationConstants.ERROR_LOGGER_NAME).log(Level.SEVERE, ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("ExecptionError") + " : " + ex.getMessage());
			if (!this.isSilent) {
				Messages.addErrorMessage(ResourceBundle.getBundle("/CSStreamerResources", Locale.getDefault()).getString("PersistenceErrorOccured"));
			}
		}
		this.isSilent = false;
		this.isEmbeddableKeys = true;
		this.isWebSyncRequested = true;
	}

	public List<Devices> getAll() {
		return getFacadeLocal().findAll(true);
	}

	public List<Devices> getItems(boolean isFilterNeeded) {
			items = getFacadeLocal().findAll(isFilterNeeded);
		return items;
	}

	public Devices getDevices(java.lang.String id, boolean isFilterNeeded) {
		return getFacadeLocal().find(id, isFilterNeeded);
	}

}
