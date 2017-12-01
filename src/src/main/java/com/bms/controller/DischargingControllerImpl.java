package com.bms.controller;

import com.bms.model.ChargingAndDischargingModelImpl;
import com.bms.view.ChargingAndDischargingView;

public class DischargingControllerImpl implements DischargingController {

	private ChargingAndDischargingModelImpl model;
	private ChargingAndDischargingView view;
	private SensorControllerImpl sensor;
	private boolean isCharging;
	private float batteryPercentage;

	// Singleton
	private static final DischargingControllerImpl instance = new DischargingControllerImpl();

	private void updateView() {
		String message = "";
		if (isCharging) {
			message = "Battery is charging and battery percentage is " + batteryPercentage;
		} else {
			message = "Battery is discharging and battery percentage is " + batteryPercentage;
		}
		view.DisplayChargingMessage(message);
	}

	public static DischargingControllerImpl getInstance() {
		return instance;
	}

	@Override
	public void callDischargingSystem() {
		model = ChargingAndDischargingModelImpl.getInstance();
		view = ChargingAndDischargingView.getInstance();
		sensor = SensorControllerImpl.getInstance();
		batteryPercentage = sensor.getBatterPercentage();
		sensor.setIsCharging(false);
		isCharging = sensor.isCharging();

		model.checkBatteryLevel(batteryPercentage, isCharging);

		updateView();
	}
}