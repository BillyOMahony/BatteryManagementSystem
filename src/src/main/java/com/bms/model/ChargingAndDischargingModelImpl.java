package com.bms.model;

//import com.bms.controller.PowerSavingModeControllerImpl;
import com.bms.controller.SensorControllerImpl;

public class ChargingAndDischargingModelImpl implements ChargingAndDischargingModel {

	// Singleton
	private static final ChargingAndDischargingModelImpl instance = new ChargingAndDischargingModelImpl();

	public void warnUser(String message) {
		System.out.println(message);
	}

	public static ChargingAndDischargingModelImpl getInstance() {
		return instance;
	}

	@Override
	public float checkBatteryLevel(float batteryPercentage, boolean ischarging) {
		try {
			SensorControllerImpl sensor = SensorControllerImpl.getInstance();

			if (ischarging) {
				if (batteryPercentage == 1) {
					sensor.setIsBreakCharging(false);
					warnUser("Battery is full, please unplug" + "\n" + " and break charging disabled" + "\n"
							+ "Current is " + sensor.getCurrent() + "amp" + "\n" + "Voltage is " + sensor.getVoltage()
							+ " volts");
				} else {
					sensor.setIsBreakCharging(false);
					warnUser("Battery percentage is " + batteryPercentage + "\n and break charging disabled" + "\n"
							+ "Current is " + sensor.getCurrent() + "amp" + "\n" + "Voltage is " + sensor.getVoltage()
							+ " volts");
				}
			} else {
				if (batteryPercentage <= .05) {
					sensor.setIsBreakCharging(true);
					warnUser("break charging enabled" + "\n" + "Battery is critically low, please charge to continue"
							+ "\n" + "Power saving mode started");
					//PowerSavingModeControllerImpl.getInstance().setPowerSavingEnabled(true);
					//PowerSavingModeControllerImpl.getInstance().CallPowerSavingSystem();
				} else {
					sensor.setIsBreakCharging(true);
					warnUser("break charging enabled" + "\n" + "Battery percentage is " + batteryPercentage);
					//PowerSavingModeControllerImpl.getInstance().setPowerSavingEnabled(true);
					//PowerSavingModeControllerImpl.getInstance().CallPowerSavingSystem();
				}
			}

		} catch (Exception e) {
			warnUser("battery percentage or charging status parameters are in appropriate, check sensors");
			e.printStackTrace();
			return 0;
		}
		return batteryPercentage;
	}

	private void test() {
		// if (ischarging && batteryPercentage == 0) {
		// sensor.setIsBreakCharging(false);
		// warnUser("Battery being charged with " + batteryPercentage + " and break
		// charging disabled");
		// System.out.println("Current is " + sensor.getCurrent() + "amp" + "\n" +
		// "Voltage is "
		// + sensor.getVoltage() + " volts");
		// } else if (batteryPercentage <= 5 && !ischarging) {
		// sensor.setIsBreakCharging(true);
		// warnUser("break charging enabled" + "\n" + "Battery is critically low, please
		// charge to continue" + "\n"
		// + "Power saving mode started");
		// PowerSavingModeControllerImpl.getInstance().setPowerSavingEnabled(true);
		// PowerSavingModeControllerImpl.getInstance().CallPowerSavingSystem();
		// } else if (batteryPercentage == 100 && ischarging) {
		// sensor.setIsBreakCharging(false);
		// warnUser("Battery is full, please unplug" + "\n" + "Current is " +
		// sensor.getCurrent() + "amp" + "\n"
		// + "Voltage is " + sensor.getVoltage() + " volts");
		// } else {
		// warnUser("battery percentage or charging status parameters are not
		// appropriate, check sensors");
		// }
	}
}