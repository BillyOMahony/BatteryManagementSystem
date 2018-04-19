package com.bms.controller;

import com.bms.model.ChargingAndDischargingModelImpl;
import com.bms.view.ChargingAndDischargingView;


/**
 * Implements ChargingDischarging controller
 * 
 * @author revathi
 *
 */
public class ChargingDischargingControllerImpl implements ChargingDischargingController {

	private ChargingAndDischargingModelImpl model;
	private ChargingAndDischargingView view;
	private SensorControllerImpl sensor;
	private boolean isCharging;
	private float batteryPercentage;

	// Singleton
	private static final ChargingDischargingControllerImpl CDINSTANCE = new ChargingDischargingControllerImpl();

	/**
	 * Updates UI with the message
	 */
	private void updateView() {
		String message;
		if (isCharging) {
			message = "Charging controller: Battery charger plugged in and battery percentage is " + batteryPercentage;

		} else {
			message = "Discharge controller: Battery is discharging and battery percentage is " + batteryPercentage;
		}
		view.DisplayChargingMessage(message);
	}

	/**
	 * Returns instance
	 * 
	 * @return
	 */
	public static ChargingDischargingControllerImpl getInstance() {
		return CDINSTANCE;
	}

	/**
	 * calls Charging discharging model
	 */
	@Override
	public void callChargingDischargingSystem() {
		model = ChargingAndDischargingModelImpl.getInstance();
		view = ChargingAndDischargingView.getInstance();
		sensor = SensorControllerImpl.getInstance();
		batteryPercentage = sensor.getBatterPercentage();
		isCharging = sensor.isCharging();
		updateView();

		model.checkBatteryLevel(batteryPercentage, isCharging);

	}
}