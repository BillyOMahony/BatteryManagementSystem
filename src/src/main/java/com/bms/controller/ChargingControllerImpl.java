package com.bms.controller;

import com.bms.model.ChargingAndDischargingModelImpl;
import com.bms.view.ChargingAndDischargingView;

public class ChargingControllerImpl implements ChargingController {

	private ChargingAndDischargingModelImpl model;
	private ChargingAndDischargingView view;
	private SensorControllerImpl sensor;
	private boolean isCharging;
	private float batteryPercentage;

	// Singleton
	private static final ChargingControllerImpl instance = new ChargingControllerImpl();

	@Override
	public void callChargingSystem() {
		model = ChargingAndDischargingModelImpl.getInstance();
		view = ChargingAndDischargingView.getInstance();
		sensor = SensorControllerImpl.getInstance();
		batteryPercentage = sensor.getBatterPercentage();
		sensor.setIsCharging(true);
		isCharging = sensor.isCharging();

		model.checkBatteryLevel(batteryPercentage, isCharging);

		updateView();
	}

	private void updateView() {
		String message = "";

		if (isCharging) {
			message = "Battery charger plugged in and battery percentage is " + batteryPercentage;
		
		} else {
			message = "Battery discharging and battery percentage is " + batteryPercentage;
		}

		view.DisplayChargingMessage(message);
	}

	public static ChargingControllerImpl getInstance() {
		return instance;
	}
}
