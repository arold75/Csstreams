package com.csstreamer.sessions;

import java.util.ArrayList;
import java.util.List;

import com.csstreamer.DOA.Devices_DAO;
import com.csstreamer.constants.ApplicationConstants;
import com.csstreamer.entities.Devices;

public class DevicesFacade {

	private static Devices_DAO devicesDAO;

	public DevicesFacade() {
		try {
			devicesDAO = Devices_DAO.getInstance();
		} catch (Exception ex) {
			devicesDAO = null;
		}
	}

	/**********************
	 * TABLE INITIALIZATION
	 ***********************/
	public boolean initializeTable() {
		boolean isInitialised = false;

		if (devicesDAO != null) {
			isInitialised = devicesDAO.initializeTable();
		}
		return isInitialised;
	}

	/**********************
	 * CREATE INSTANCE
	 ***********************/
	public boolean create(Devices device) {
		boolean isCreated = false;

		if (devicesDAO != null) {

			if (device != null) {
				isCreated = devicesDAO.create(device);
			}
		}
		return isCreated;
	}

	/***************************
	 * UPDATE INSTANCE
	 ****************************/
	public boolean edit(Devices device) {
		boolean isEdited = false;

		if (devicesDAO != null) {

			if (device != null) {

				if (device.getDeviceId() != null) {
					isEdited = devicesDAO.edit(device);
				}
			}
		}
		return isEdited;
	}

	/**************************
	 * DELETE INSTANCE
	 ***************************/
	public boolean remove(Devices device) {
		boolean isDeleted = false;

		if (devicesDAO != null) {

			if (device != null) {

				if (device.getDeviceId() != null) {
					isDeleted = devicesDAO.remove(device);
				}
			}
		}
		return isDeleted;
	}

	/**************************
	 * DELETE ALL
	 ***************************/
	public boolean removeAll() {
		boolean isAllDeleted = false;

		if (devicesDAO != null) {
			isAllDeleted = devicesDAO.removeAll();
		}
		return isAllDeleted;
	}

	/**************************
	 * FIND
	 ***************************/
	public Devices find(String Id, boolean isFilterNeeded) {
		Devices device = null;

		if (devicesDAO != null) {
			
			if (Id != null) {
				device = (Devices) devicesDAO.find(Id);
				
				if(isFilterNeeded && device != null) {
					device = filterObject(device);
				}
			}
		}
		return device;
	}

	/**************************
	 * FIND ALL
	 ***************************/
	public List<Devices> findAll(boolean isFilterNeeded) {
		List<Devices> listDevices = null;

		if (devicesDAO != null) {
			listDevices = (List<Devices>) devicesDAO.findAll();

			if (listDevices != null) {
				if (listDevices.isEmpty()) {
					listDevices = null;
				}else {
					if(isFilterNeeded) {
						listDevices = filterList(listDevices);
					}
				}
			}
		}
		return listDevices;
	}
	
	private Devices filterObject(Devices object) {
		Devices filteredObject = null;

		if (object != null) {
			if ((object.getDeviceStatus() & ApplicationConstants.STATUS_MARK_DELETED) == 0) {
				filteredObject = object;
			}
		}

		return filteredObject;

	}

	private List<Devices> filterList(List<Devices> listObjects) {
		List<Devices> filteredListObjects = null;

		if (listObjects != null) {
			if (!listObjects.isEmpty()) {
				filteredListObjects = new ArrayList<>();

				for (int folder = 0; folder < listObjects.size(); folder++) {
					if ((listObjects.get(folder).getDeviceStatus() & ApplicationConstants.STATUS_MARK_DELETED) == 0) {
						filteredListObjects.add(listObjects.get(folder));
					}
				}
				if (filteredListObjects.isEmpty()) {
					filteredListObjects = null;
				}
			}
		}
		return filteredListObjects;
	}
	
}
