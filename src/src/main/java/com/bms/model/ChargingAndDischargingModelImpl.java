package com.bms.model;

import com.bms.controller.SensorControllerImpl;

public class ChargingAndDischargingModelImpl implements ChargingAndDischargingModel {

	// Singleton
	private static final ChargingAndDischargingModelImpl instance = new ChargingAndDischargingModelImpl();

	public void warnUser(String message) {
		System.out.println("Battery is critically low, please charge to continue:");
	}

	public static ChargingAndDischargingModelImpl getInstance() {
		return instance;
	}

	@Override
	public float checkBatteryLevel(float batteryPercentage, boolean ischarging) {
		if (batteryPercentage <= 5) {
			warnUser("Battery is critically low, please charge to continue:");
		} else if (batteryPercentage == 100) {
			warnUser("Battery is full, please unplug");
		}
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		if (ischarging) {
			sensor.setIsBreakCharging(false);
			System.out.println("Battery being charged and break charging disabled");
			System.out.println("Current is " + sensor.getCurrent() + "amp");
			System.out.println("Voltage is " + sensor.getVoltage() + " volts");
		} else {
			sensor.setIsBreakCharging(true);
			System.out.println("break charging enabled");
		}
		return batteryPercentage;
	}
}