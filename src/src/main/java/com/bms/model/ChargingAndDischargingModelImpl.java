package com.bms.model;

import com.bms.controller.PowerSavingModeControllerImpl;
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
		try {
			SensorControllerImpl sensor = SensorControllerImpl.getInstance();
			if (batteryPercentage <= 5 && !ischarging) {
				sensor.setIsBreakCharging(true);
				System.out.println("break charging enabled");
				warnUser("Battery is critically low, please charge to continue");
				warnUser("Power saving mode started");
				PowerSavingModeControllerImpl.getInstance().setPowerSavingEnabled(true);
				PowerSavingModeControllerImpl.getInstance().CallPowerSavingSystem();
			} else if (batteryPercentage == 0 && ischarging) {
				sensor.setIsBreakCharging(false);
				System.out.println("Battery being charged and break charging disabled");
				System.out.println("Current is " + sensor.getCurrent() + "amp");
				System.out.println("Voltage is " + sensor.getVoltage() + " volts");
				System.out.println("Battery charging with " + batteryPercentage + "%");
			} else if (batteryPercentage == 100 && ischarging) {
				sensor.setIsBreakCharging(false);
				System.out.println("Battery being charged and break charging disabled");
				System.out.println("Current is " + sensor.getCurrent() + "amp");
				System.out.println("Voltage is " + sensor.getVoltage() + " volts");
				warnUser("Battery is full, please unplug");
			} else {
				System.out
						.println("battery percentage or charging status parameters are not appropriate, check sensors");
			}
		} catch (Exception e) {
			System.out.println("battery percentage or charging status parameters are in appropriate, check sensors");
			e.printStackTrace();
			return 0;
		}
		return batteryPercentage;
	}
}